package com.hibernate.loanapp.mapping.Many2Many;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer", schema="hibernate")
public class GymCustomer {
	
	@Id
	@Column(name="id")
	private int customerid;
	@Column(name="name")
	private String name;
	@Column(name="dateofbirth")
	private LocalDate date;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="custgym", schema="hibernate",
	joinColumns = @JoinColumn(name = "customerid", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "packageid", referencedColumnName = "packageid"))
	private List<GymPackage> gymPackage;
	
	public GymCustomer(){
		
	}
	public GymCustomer(int customerid, String name, LocalDate date) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.date = date;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<GymPackage> getGymPackage() {
		return gymPackage;
	}
	public void setGymPackage(List<GymPackage> gymPackage) {
		this.gymPackage = gymPackage;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
