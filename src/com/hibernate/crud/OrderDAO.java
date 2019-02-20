package com.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO implements OrderDAOInterface {

	@Override
	public void addOrder(OrderTbl order) {
		//Takes in Order object and creates/inserts in to DB table
		Session session = HibernateUtil.getSession().openSession();
		Transaction trans = session.beginTransaction();
		session.save(order);
		trans.commit();
		session.close();
	
	}

}
