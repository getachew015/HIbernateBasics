package com.hibernate.loanapp.mapping.one2one;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
Banking App: Introducing Locker Facility to its customers. 
A customer can avail locker service and locker cannot be shared by more than one customer. 
• @OneToOne(cascade = CascadeType.ALL)  
This annotation is applied to reference attribute of Locker in the Customer entity which indicates that 
the relationship has one to one cardinality. The cascade attribute of the annotation is mandatory. 
This attribute transfers operations (such as insert, update, delete) done on Customer object to its Locker object.

• @JoinColumn(name = "lockerId", unique = true)
In this annotation, the name attribute specifies the name of the foreign key column in the Customer table. 
The unique attribute assures unique values in the foreign key column to achieve one to one mapping
*/

@Entity
@Table(name="customerlocker", schema="hibernate")
public class CustomerLocker {
	
	@Id
	@Column(name="customerid")
	private int customerid;
	@Column(name="customername")
	private String customername;
	@Column(name="dateofbirth")
	private LocalDate dateofbirth;
	@Column(name="address")
	private String address;
	@Column(name="phonenumber")
	private String phonenumber;
	//one customer can have one lock for its account
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="lockerid", unique=true)
	private Locker locker;

	public CustomerLocker(){
		
	}

	public CustomerLocker(int customerid, String customername, LocalDate dateofbirth, 
			String address, String phonenumber) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.phonenumber = phonenumber;
	}

	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public LocalDate getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Locker getLocker() {
		return locker;
	}
	public void setLocker(Locker locker) {
		this.locker = locker;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", dateofbirth=" + dateofbirth
				+ ", address=" + address + ", phonenumber=" + phonenumber + ", lockerid=" + locker + "]";
	}
	
}
