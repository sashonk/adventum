package adventum.model;

import adventum.util.HasName;
import adventum.model.Identity;



public class Person  implements Identity, HasName{

	public String getFirstName(){
		return m_firstName;
	}
	 
	public void setFirstName(final String name){
		m_firstName = name;
	}
	
	public void setLastName(final String name){
		m_lastName = name;
	}
		
	public String getLastName(){
		return m_lastName;
	}

	public Integer getId(){
		return m_id;
	}
	
	public void setId(final Integer id){
		m_id= id;
	}
	
	public void setEmail(String email){
		m_email = email;
	}
	
	public String getEmail(){
		return m_email
				;
	}	
	
	public String getLogin(){
		return m_login;
	}
	
	public void setLogin(String value){
		m_login = value;
	}
	

	private String m_login;
	private String m_lastName;
	private String m_email;
	private String m_firstName;
	private Integer m_id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m_id == null) ? 0 : m_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (m_id == null) {
			if (other.m_id != null)
				return false;
		} else if (!m_id.equals(other.m_id))
			return false;
		return true;
	}




}
