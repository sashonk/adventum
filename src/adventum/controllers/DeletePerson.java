package adventum.controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
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
import adventum.model.Roles;
import adventum.util.ModelUtil;
import adventum.util.Utils;



@RequestMapping("/admin/delete.html")
@Controller
public class DeletePerson {
	 

	   @RequestMapping(method = RequestMethod.GET, params={"id"})
	    public ModelAndView delete(
	    		@RequestParam(value="id") int id) {		   		
	       ModelAndView view = new ModelAndView("delete");
		   Person p = dao.findPerson(id);
		  
		   if(p!=null){
				  String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
				  if(currentUser.equals(p.getLogin())){
					  view.getModel().put("message", "Вы не можете удалить себя");
				  }
				  else{
					   view.getModel().put("name", p.getLogin());
					   dao.deletePerson(id);
				  }
			   
	
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
