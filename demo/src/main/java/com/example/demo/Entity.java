package com.example.demo;

@jakarta.persistence.Entity
public class Entity {
	
	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
	@jakarta.persistence.Id
	private int Id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

}
