package PojoClasses;

import java.util.List;

public class Token {
	
	
	private String userName;
	private String password;
	private List<LoginClaims> loginClaims;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<LoginClaims> getLoginClaims() {
		return loginClaims;
	}
	public void setLoginClaims(List<LoginClaims> loginClaims) {
		this.loginClaims = loginClaims;
	}
	
	

}
