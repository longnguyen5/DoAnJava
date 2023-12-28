package model;

public class Employee extends User {
	private String position;

	public Employee(int userId, String username, String password, String email, String firstName, String lastName,
			String position) {
		super(userId, username, password, email, firstName, lastName);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
