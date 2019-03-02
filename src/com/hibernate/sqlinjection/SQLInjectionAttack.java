package com.hibernate.sqlinjection;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.crud.HibernateUtil;

public class SQLInjectionAttack {

	public static void main(String[] args) {
		/*
		 •	Positioned Parameter: uses question mark (?) to define a named parameter in the query, and according to the position sequence, the value is set to the parameter.
		 •	Named Parameter: uses colon followed by a parameter name (:example) to define a named parameter in the query.
		 */
		char choice =0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 'P' for Positioned Parameter and 'N' for Named Parameter");
		choice = scan.next().toString().charAt(0);
		switch (choice) {
		case 'P':{
			System.out.println("Enter OrderId");
			String id = scan.next();
			System.out.println("Enter Quantity");
			Integer quantity = (Integer)scan.nextInt();
			SQLInjectionAttack.listOrdersPositionedParam(id, quantity);
			break;
		}
		case 'N':{
			System.out.println("Enter OrderId");
			SQLInjectionAttack.listOrdersNamedParam(scan.next());			
			break;
		}
		default:
			break;
		}
	}
	
	public static void listOrdersPositionedParam(String orderId, Integer quantity){
		/*
		 •	Query setParameter (int position, Object Value)
		 •	Query setXXX (int position, Object Value) 
		 •	Query setProperties (Object object)
		 */
		Session session = HibernateUtil.getSession().openSession();
		//This returns exception ---> Legacy-style query parameters (`?`) are no longer supported;
		try {
			Query<Object[]> query = session.createQuery("select o.orderId, o.productQuantity from "
					+ "OrderTbl o where o.orderId = ? and o.productQuantity > ?");
			query.setParameter(0, orderId);
			query.setParameter(1, quantity);
			query.executeUpdate();
			List<Object[]> list = query.list();
			list.forEach(order -> System.out.println("OrderId - "+order[0]+" Product Quantity - "+order[1]));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	
	public static void listOrdersNamedParam(String orderId){
		/*
		 •	Query setParameter (String name, Object Value)
		 •	Query setXXX (String name, Object Value)
		 •	Query setProperties (Object object)
		 */
		Session session = HibernateUtil.getSession().openSession();
		Query<Object[]> query = session.createQuery("select o.orderId, o.productQuantity from OrderTbl o "
				+ "where orderId = :id");
		query.setParameter("id", orderId);
		List<Object[]> list = query.list();
		list.forEach(order -> System.out.println("OrderId - "+order[0]+" ProductId - "+order[1]));
		session.close();
	}

}
