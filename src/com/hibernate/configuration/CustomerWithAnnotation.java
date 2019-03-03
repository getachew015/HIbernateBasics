package com.hibernate.configuration;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Customer")
public class CustomerWithAnnotation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="dateofBirth")
	private LocalDate dateOfBirth;
	@Transient
	private String stringVal;
	
	public CustomerWithAnnotation(){
		
	}
	
	public CustomerWithAnnotation(int id, String name, LocalDate dateOfBirth) {
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
		stringVal = ("Id: " +id+" Name: "+name+" Birth Date:" +dateOfBirth);
		return stringVal;
	}

}
