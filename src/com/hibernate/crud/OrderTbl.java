package com.hibernate.crud;

import java.io.Serializable;

public class OrderTbl implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String productId, orderId;
	private String productName;
	private int productQuantity;
	
	public OrderTbl(){
		
	}
	public OrderTbl(String orderId, String productId, String productName, int productQuantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String toString(){
		return (orderId + " "+productId+" "+ productName+" "+productQuantity);
	}

}
