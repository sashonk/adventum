package adventum.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.support.RequestContextUtils;

import adventum.dao.PersonDAO;
import adventum.mappers.PersonMapper;
import adventum.model.Person;
import adventum.model.Roles;

public class Personal  extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView view = new ModelAndView("personal");
		Map<String, Object> model = view.getModel();				
		List<Person> personal = getDao().getPersonal();	
		model.put("data", personal);
		
		
		model.put("admin_count", dao.getCountByRole(Roles.ADMIN));
		model.put("user_count", dao.getCountByRole(Roles.USER));
		model.put("manager_count", dao.getCountByRole(Roles.MANAGER));
		
		return view;
	}

	
	private PersonDAO dao;
	
	public PersonDAO getDao(){
		return dao;
	}
	
	public void setDao(PersonDAO d)
	{
		dao = d;
	}
	
	
}
