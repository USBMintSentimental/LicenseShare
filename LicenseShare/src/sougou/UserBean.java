package sougou;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String username;
	private String passwd;
	private String role;
	private int pass;
	
	public UserBean() {
		
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
	this.passwd = passwd;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getPass() {
		return pass;
	}
	
	public void setPass(int pass) {
	this.pass = pass;
	}
	
}