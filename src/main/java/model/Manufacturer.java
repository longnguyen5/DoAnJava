package model;

public class Manufacturer {
	private int manufacturerId;
	private String manufacturerName;
	private String address;
	private String phoneNumber;

	public Manufacturer() {
	}

	public Manufacturer(int manufacturerId, String manufacturerName, String address, String phoneNumber) {
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
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

	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
}
