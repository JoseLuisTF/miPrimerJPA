package entities;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String email;
	private String address;
	private String phone_number;
	private String last_name;
	private String name_user;
	private String password;

	public User(){
		
	}



	public User(String name, String email, String address, String phone_number, String last_name, String name_user,
			String password) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone_number = phone_number;
		this.last_name = last_name;
		this.name_user = name_user;
		this.password = password;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

}
