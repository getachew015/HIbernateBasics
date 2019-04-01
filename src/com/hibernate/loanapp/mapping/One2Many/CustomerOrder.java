package com.hibernate.loanapp.mapping.One2Many;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customerordrtbl", schema="hibernate")
public class CustomerOrder {

	@Id
	@Column(name="customerid")
	private int customerId;
	@Column(name="address")
	private String address;
	@Column(name="phonenumber")
	private String phoneNumber;
	//One Customer can order multiple Orders
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerid", insertable=true, unique=true)
	private List<OrderCustomer> orderList;

	public CustomerOrder(){
		
	}
	public CustomerOrder(int customerId, String address, String phoneNumber) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public List<OrderCustomer> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderCustomer> orderList) {
		this.orderList = orderList;
	}

}
