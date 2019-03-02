package com.hibernate.autogeneration;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO implements ProductInterface {

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.save(product);
		trans.commit();
	}

}
