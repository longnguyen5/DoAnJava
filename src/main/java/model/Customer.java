package model;

public class Customer extends User {
	private String address;
	private String phoneNumber;

	public Customer(int userId, String username, String password, String email, String firstName, String lastName,
			String address, String phoneNumber) {
		super(userId, username, password, email, firstName, lastName);
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
