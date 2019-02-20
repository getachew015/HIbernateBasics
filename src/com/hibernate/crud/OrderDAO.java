package com.hibernate.crud;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO implements OrderDAOInterface {

	@Override
	public void addOrder(OrderTbl order) {
		//Takes in Order object and creates/inserts in to DB table
		Session session = HibernateUtil.getSession().openSession();
		Transaction trans = session.beginTransaction();
		System.out.println("Although both create operations are the same "
				+ "persist() won't return record identifier i.e primary key but save() does");
		Random random = new Random();
		int randNum = random.nextInt(7);
		if(randNum>4){
			System.out.println("Based on the Random number generated using save()");
			session.save(order);
		}else{
			System.out.println("Based on the Random number generated using persist()");
			session.persist(order);			
		}
		trans.commit();
		session.close();
	}
	
	@Override
	public OrderTbl getOrder(String orderId){
		Session session = HibernateUtil.getSession().openSession();
		Transaction trans = session.beginTransaction();
		Random random = new Random();
		int randNum= random.nextInt(7); 
		OrderTbl orderRecord = null;
		/*
		• Object get(Class , Serializable idValue)
			Retrieves an instance of the entity class with the given primary key value. 
			If no such record exists in the database table or persistence context, the method returns NULL value.
		• Object load(Class class, Serializable idValue)
			Retrieves a proxy instance of the entity class with the given primary key value. 
			If the requested row is unavailable in the database table, ObjectNotFoundException is thrown. When using load(), 
			Hibernate does not hit the database but initializes the entity object by doing 
			lazy loading(defer initialization of an object until the point at which it is needed). This enhances the performance.
		 */
		if( randNum > 3 ){
			System.out.println("Based on the random number generated it used get() to fetch record which uses eager loading");
			orderRecord = session.get(OrderTbl.class, orderId);
			System.out.println(orderRecord.toString());
		}
		else{
			System.out.println("Based on the random number generated it used load() to fetch record which uses lazy loading");
			orderRecord = session.load(OrderTbl.class, orderId);
			System.out.println(orderRecord.toString());
		}
		trans.commit();
		session.close();
		return orderRecord;
	}
	@Override
	public void updateOrder(String orderId, OrderTbl orderRec){
		Session session = HibernateUtil.getSession().openSession();
		OrderTbl order = session.get(OrderTbl.class, orderId);
		order.setProductId(orderRec.getProductId());
		order.setProductName(orderRec.getProductName());
		order.setProductQuantity(order.getProductQuantity());
		Transaction trans = session.beginTransaction();		
		Random random = new Random();
		int randNum = random.nextInt(5);
		/*
		 saveOrUpdate() method calls either save() or update() on the basis of identifier exists or not in the mapped table. 
		 it internally invokes save(), if the object does not exist other wise it invokes update(). 
		 */
		if(randNum > 2){
			System.out.println("Based on the random number generated updated Record using update() method");
			session.update(order);			
		}else{
			System.out.println("Based on the random number generated updated Record Using saveOrUpdate() method");
			session.saveOrUpdate(order);
		}
		trans.commit();
		session.close();	
	}
	
	@Override
	public void deleteOrder(String orderId){
		/*
		•	The entity instance is retrieved from the database using get() or load().
		•	Invoke void delete(Object object) to remove the corresponding row from the database table.
		•	The changes are committed by an active transaction using commit().
		 */
		Session session  = HibernateUtil.getSession().openSession();
		Transaction trans = session.beginTransaction();
		OrderTbl order = session.get(OrderTbl.class, orderId);
		session.delete(order);
		trans.commit();
		session.close();
	}

}
