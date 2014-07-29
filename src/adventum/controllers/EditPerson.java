package adventum.controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import adventum.dao.PersonDAO;
import adventum.model.Person;
import adventum.model.PersonForm;
import adventum.model.Roles;
import adventum.util.Utils;





@RequestMapping("/admin/person.html")
@Controller
public class EditPerson {
	
	public static List<String> validate(PersonForm form ){
		List<String> errors = new LinkedList<String>();

		
		if(!Utils.isValidEmailAddress(form.getEmail())){
			errors.add("неправильный формат E-mail");
		}
		
		if(!form.isRoleAdmin() && !form.isRoleManager() && !form.isRoleUser()){
			errors.add("должна быть хотя бы одна роль");
		}
		//TODO more validation
		return errors;
	}
	 
	 @RequestMapping(method=RequestMethod.GET, params={"id"})
	 public ModelAndView edit(@RequestParam(value="id") final int id) {
		 		 		  
	       ModelAndView view = new ModelAndView("person");
	       Person p = dao.findPerson(id);
	       
	       PersonForm pf = new PersonForm();
	       pf.setEmail(p.getEmail());
	       pf.setFirstName(p.getFirstName());
	       pf.setLastName(p.getLastName());
	       pf.setLogin(p.getLogin());
	       pf.setId(id);
	       
	       List<String> roles = dao.getAuthorities(id);	       
	       pf.setRoleAdmin(roles.contains(Roles.ADMIN));
	       pf.setRoleManager(roles.contains(Roles.MANAGER));
	       pf.setRoleUser(roles.contains(Roles.USER));
	       
	       
	       view.getModel().put("personForm", pf);
	 
	       return view;
	 }
	


	   @RequestMapping(method = RequestMethod.POST)
	    public ModelAndView create(@ModelAttribute(value="personForm") PersonForm form
	  ) {		   					  
		  dao.updatePerson(form.getId(),form.getFirstName(), form.getLastName(), form.getEmail());
		  
		  
	      ModelAndView view = new ModelAndView("person");
	       List<String> validationErrors = validate(form);
		   if(validationErrors.size()==0){
				 Person p = dao.findPerson(form.getId());
				  List<String> roles = new LinkedList<String>();
				  if(form.isRoleAdmin()){
					  roles.add(Roles.ADMIN);
				  }
				  if(form.isRoleManager()){
					  roles.add(Roles.MANAGER);
				  }
				  if(form.isRoleUser()){
					  roles.add(Roles.USER);
				  }
				 dao.updateAuthorities(p.getLogin(), roles);
				 
				  
			       view.getModel().put("message", new StringBuilder("пользователь ").append(form.getLastName()).append(" отредактирован").toString());
			     
			       
		   }
		   else{
		       view.getModel().put("errors", validationErrors);
		   }
		   
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
