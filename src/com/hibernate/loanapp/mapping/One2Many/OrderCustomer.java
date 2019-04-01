package com.hibernate.loanapp.mapping.One2Many;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hibernate.loanapp.mapping.one2one.CustomerLocker;

@Entity
@Table(name="ordercusttbl", schema="hibernate")
public class OrderCustomer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="orderid")
	private String orderId;
	@Column(name="productid")
	private String productId;
	@Column(name="productname")
	private String productName;
	@Column(name="productquantity")
	private String productQuantity;

	public OrderCustomer(){
		
	}
	public OrderCustomer(String orderId, String productId, String productName, String productQuantity,
			CustomerLocker customer) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "OrderCustomer [orderId=" + orderId + ", productId=" + productId + ", productName=" + productName
				+ ", productQuantity=" + productQuantity +  "]";
	}
	
}
