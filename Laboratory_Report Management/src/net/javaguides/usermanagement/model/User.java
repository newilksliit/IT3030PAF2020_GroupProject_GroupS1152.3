package net.javaguides.usermanagement.model;


public class User {
	protected int id;
	protected String name;
	protected String email;
	protected String address;
	
	public User() {
	}
	
	public User(String name, String email, String address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public User(int id, String name, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCountry() {
		return address;
	}
	public void setCountry(String address) {
		this.address = address;
	}
}
