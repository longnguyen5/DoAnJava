package model;

public class User {
	private int Id;
	private String firstname;
	private String lastname;
	private String email;
    private String address;
    private String phone;
    
	public User() {
	}

	public User(int id, String firstname, String lastname, String email, String address, String phone) {
		this.Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + "]";
	}

}