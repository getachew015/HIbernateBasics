package com.hibernate.configuration;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable{

	private static final long serialVersionUID = -7741207174259258042L;
	private int id;
	private String name;
	private LocalDate dateOfBirth;
	
	public Customer(){
		
	}
	public Customer(int id, String name, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String toString(){
		
		return ("Id: " +id+" Name: "+name+" Birth Date:" +dateOfBirth);
	}

}
