package adventum.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;






import adventum.dao.PersonDAO;
import adventum.model.Person;
import adventum.model.PersonForm;
import adventum.model.Roles;
import adventum.util.Utils;




@RequestMapping("/admin/create.html")
@Controller
public class CreatePerson {
	 
	public static List<String> validate(PersonForm form ){
		List<String> errors = new LinkedList<String>();
		
		if(form.getPassword().length()<6){
			errors.add("пароль должен быть не короче 6 символов");
		}
		
		if(!Utils.isValidEmailAddress(form.getEmail())){
			errors.add("неправильный формат E-mail");
		}
		
		if(!form.isRoleAdmin() && !form.isRoleManager() && !form.isRoleUser()){
			errors.add("должна быть хотя бы одна роль");
		}
		
	
		//TODO more validation
		return errors;
	}
	
	 @RequestMapping(method=RequestMethod.GET)
	 @ModelAttribute(value="person")
	 public ModelAndView create() {
		 		  
	         ModelAndView view = new ModelAndView("create");
	         PersonForm p = new PersonForm();
	         view.getModel().put("personForm", p);
	         return view;
	 
	 }

	   @RequestMapping(method = RequestMethod.POST)
	    public ModelAndView create(
	    	@ModelAttribute(value="personForm") PersonForm personForm
) {		   					  
		   
	       ModelAndView view = new ModelAndView("create");
	       List<String> validationErrors = validate(personForm);
	       
	       if(validationErrors.isEmpty()){
		       Person p = dao.findPersonByLogin(personForm.getLogin());
		       if(p!=null){
		    	   validationErrors.add("пользователь с таким логином уже зарегистрирован");
		       }
	       }
	       
		   if(validationErrors.size()==0){
				  dao.createPerson(personForm.getFirstName(), personForm.getLastName(), personForm.getEmail(), personForm.getLogin(), personForm.getPassword());

				  List<String> roles = new LinkedList<String>();
				  if(personForm.isRoleAdmin()){
					  roles.add(Roles.ADMIN);
				  }
				  if(personForm.isRoleManager()){
					  roles.add(Roles.MANAGER);
				  }
				  if(personForm.isRoleUser()){
					  roles.add(Roles.USER);
				  }
				  
				  dao.updateAuthorities(personForm.getLogin(), roles);
				  
			       view.getModel().put("message", new StringBuilder("пользователь ").append(personForm.getLastName()).append(" добавлен").toString());
			     
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
