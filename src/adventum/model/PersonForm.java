package adventum.model;

import java.io.Serializable;

public class PersonForm implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 4870064119642990939L;
	private boolean roleManager;
	public boolean isRoleManager() {
		return roleManager;
	}
	public void setRoleManager(boolean roleManager) {
		this.roleManager = roleManager;
	}
	public boolean isRoleUser() {
		return roleUser;
	}
	public void setRoleUser(boolean roleUser) {
		this.roleUser = roleUser;
	}
	public boolean isRoleAdmin() {
		return roleAdmin;
	}
	public void setRoleAdmin(boolean roleAdmin) {
		this.roleAdmin = roleAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getId(){
		return id;
	}
	public void setId(int v){
		id = v;
	}
	
	private boolean roleUser;
	private boolean roleAdmin;
	private String password;
	private String login;
	private String lastName;
	private String email;
	private String firstName;
	private int id;
}
