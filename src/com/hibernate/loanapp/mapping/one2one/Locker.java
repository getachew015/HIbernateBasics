package com.hibernate.loanapp.mapping.one2one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locker", schema="hibernate")
public class Locker {
	@Id
	@Column(name="lockerid")
	private String lockerid;
	@Column(name="lockertype")
	private String lockertype;
	@Column(name="rent")
	private int rent;
	
	public Locker(){
		
	}
	public Locker(String lockerid, String lockertype, int rent) {
		super();
		this.lockerid = lockerid;
		this.lockertype = lockertype;
		this.rent = rent;
	}
	public String getLockerid() {
		return lockerid;
	}
	public void setLockerid(String lockerid) {
		this.lockerid = lockerid;
	}
	public String getLockertype() {
		return lockertype;
	}
	public void setLockertype(String lockertype) {
		this.lockertype = lockertype;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	@Override
	public String toString() {
		return "Locker [lockerid=" + lockerid + ", lockertype=" + lockertype + ", rent=" + rent + "]";
	}
	
}
