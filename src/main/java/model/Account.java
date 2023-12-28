package model;

public class Account {
	private String username;
	private String password;
	private int role;
	
	public Account(String username, String password, int role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

public Account() {
}

@Override
public String toString() {
	return "Account [username=" + username + ", password=" + password + ", role=" + role + "]";
}

public String getusername() {
	return username;
}

public void setusername(String username) {
	this.username = username;
}

public String getpassword() {
	return password;
}

public void setpassword(String password) {
	this.password = password;
}

public int getRole() {
	return role;
}

public void setRole(int role) {
	this.role = role;
}

}
