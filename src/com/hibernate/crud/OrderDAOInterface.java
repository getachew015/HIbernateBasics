package com.hibernate.crud;

public interface OrderDAOInterface {
	
	public void addOrder(OrderTbl order);
	public Object getOrder(String orderId);
	public void updateOrder(String orderId, OrderTbl orderRec);
	public void deleteOrder(String orderId);
	
}
