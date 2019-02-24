package com.hibernate.hql;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.crud.HibernateUtil;
import com.hibernate.crud.OrderTbl;

public class HQLDemo {
	/* Hibernate ORM provides HQL which has the Query language syntax but understands Object Oriented Paradigm.
	To work with HQL:
		•	use createQuery() method of Session Object to pass the query string.
		•	It returns a org.hibernate.Query object.
		•	Following methods can be used to retrieve values from the Query instance:
		•	list() : Returns the list of objects retrieved by the query
		•	executeUpdate(): Executes a data manipulation statement in the database
		•	uniqueResult(): Returns one unique object.
	 */

	public static void main(String[] args) {
		//Performing Update on OrderTbl records
		char choice=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your choice 'L' for Listing Records, 'U' for updating, 'D' for Deleting ");
		choice = scan.next().toString().charAt(0);
		switch (choice) {
			case 'L':{
				HQLDemo.listRecords();
				break;
			}
			case 'U':{
				System.out.println(HQLDemo.updateRecords()+" Number of Records Updated ");
				break;
			}
			case 'D':{
				System.out.println("Provide Order Id ");
				System.out.println(HQLDemo.deleteRecords(scan.next()) +" Number of Records Deleted");
				break;
			}
			default:
				break;
		}
		scan.close();
	}
	
	public static void listRecords(){
		//when writing HQL we pass the type as the table name in this case OrderTbl it should be the class name case sensitive
		Session session = HibernateUtil.getSession().openSession();
		Query<OrderTbl> queryList = session.createQuery("from OrderTbl o where o.productQuantity>5");
		List<OrderTbl> orderList = queryList.list();
		orderList.forEach(order -> System.out.println(order.toString()));
		session.close();
	}
	public static int updateRecords(){
		Session session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Query<OrderTbl> queryUpdate = session.createQuery("update OrderTbl o set o.productQuantity=9 where o.productQuantity>5");
		int returnUpdateResult = queryUpdate.executeUpdate();	
		session.getTransaction().commit();
		session.close();
		return 	returnUpdateResult;
	}
	public static int deleteRecords(String orderId){
		Session session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		/*
		 * passing parameters to HQL statments makes the code vulnerable to a SQL injection attack
		 * In the below code snipet all order records for the coresponding orderId will be fetched and attacker will be able to see the details
		 * Constructing the queries at run time using Positioned Parameter and Named Parameter are recommended ways  
		 */
		
		Query<OrderTbl> queryDelete = session.createQuery("delete OrderTbl o where o.orderId = '" +orderId+"'");
		int returnDeleteResult = queryDelete.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return returnDeleteResult;
	}
}
