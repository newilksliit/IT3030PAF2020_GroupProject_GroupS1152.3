package com;

import java.sql.Date;

public class Entity {
	private int id;
	private String name;
	private Date date;
	
	public Entity(int id, String name) {
	//	super();
		this.setId(id);
		this.setName(name);
		this.setDate(new Date(System.currentTimeMillis()));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	void setDate(Date date) {
		this.date = date;
	}
	
}
