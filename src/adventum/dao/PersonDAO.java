package adventum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import adventum.mappers.PersonMapper;
import adventum.model.Person;
import adventum.util.Utils;

public class PersonDAO {
	
	public List<Person> getPersonal(){

		List<Person> personal = getNpjt().query("select * from people order by login", new HashMap<String, Object>(), new PersonMapper());		
		return personal;
	}
	
	public Person findPersonByLogin(String login){
		Map<String, Object> mm = new HashMap<String ,Object>();
		mm.put("login", login);
		MapSqlParameterSource source = new MapSqlParameterSource(mm);
		List<Person> result = getNpjt().query("select * from people where login = :login", source, new PersonMapper());
		
		return result.size()>0 ? result.get(0) : null;
	}
	
	public int getCountByRole(String roleName){
		Map<String, Object> mm = new HashMap<String ,Object>();
		mm.put("role_name", roleName);
		return getNpjt().queryForInt("select count(1) from user_roles where role_name = :role_name", mm);
		
	}
	
	public Person findPerson(final int id){		
		Map<String, Object> mm = new HashMap<String ,Object>();
		mm.put("ID", id);
		MapSqlParameterSource source = new MapSqlParameterSource(mm);
		List<Person> result = getNpjt().query("select * from people where id = :ID", source, new PersonMapper());
		
		
		return result.size()>0 ? result.get(0) : null;
	}
	
	public List<String> getAuthorities(int personId){
		final List<String> result = new LinkedList<String>();

		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("id", personId);
		npjt.query("select p.id, ur.role_name role from people p, user_roles ur where p.login=ur.name and p.id = :id", params, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				result.add(rs.getString("role"));
			}
		});
		
		return result;
	}
	
	public void deletePerson(final int id){

		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("id", id);
		 
		String login = npjt.queryForObject("select login from people where id = :id", params, String.class);
		 		
		 Map<String, Object> pp = new HashMap<String, Object>();
		 pp.put("name", login);
		 npjt.update("delete from users where name = :name", pp);
		 npjt.update("delete from user_roles where name = :name", pp);			
		 npjt.update("delete from people where id = :id", params);
	}
	
	public void updateAuthorities(final String login, final List<String> roles){
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("name", login);		 
		 npjt.update("delete from user_roles where name = :name", params);		
		 
		 Map[] maps = new HashMap[roles.size()];
		 for(int i = 0; i<roles.size() ;i++){
			 maps[i] = new HashMap<String, Object>();
			 maps[i].put("name", login);
			 maps[i].put("role", roles.get(i));
		 }
		 npjt.batchUpdate("insert into user_roles (name, role_name) values (:name, :role)", maps);
	}
	

	
	
	public void updatePerson(final int id, String firstName, String lastName, String email){
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("id", id);
		 params.put("email", email);
		 params.put("firstName", firstName);
		 params.put("lastName", lastName);
		 
		 npjt.update("update people set email = :email, firstName = :firstName, lastName=:lastName where id = :id", params);
	}
	
	
	public int createPerson(final String firstName ,final String lastName, final String email, final String login, final String password){
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("email", email);
		 params.put("firstName", firstName);
		 params.put("lastName", lastName);
		 params.put("login", login);	
		 
		 KeyHolder holder = new GeneratedKeyHolder();
		 npjt.update("insert into people (firstName, lastName, email, login) values (:firstName, :lastName,:email, :login )", new MapSqlParameterSource(params), holder);

		 Map<String, Object> mm = new HashMap<String, Object>();
		 mm.put("password", Utils.getSha(password));
		 mm.put("login", login);	
		 npjt.update("insert into users (password, name) values (:password,  :login )", mm);
	 
		return holder.getKey().intValue();
		 //return findPerson(holder.getKey().intValue());
	}
	
	
	private NamedParameterJdbcTemplate npjt;
	
	public void setNpjt(NamedParameterJdbcTemplate n){
		npjt = n;
	}
	
	public NamedParameterJdbcTemplate getNpjt(){
		return npjt;
	}
}
