package adventum.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import adventum.model.Person;

public class PersonMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int arg1) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setEmail(rs.getString("email"));
		p.setFirstName(rs.getString("firstName"));
		p.setLastName(rs.getString("lastName"));
		p.setLogin(rs.getString("login"));
		return p;
	}
}
