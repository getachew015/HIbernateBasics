package com.hibernate.loanapp.mapping.one2one;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.crud.HibernateUtil;

public class CustomerDAO implements OnetoOneCustomer {

	@Override
	public void addNewCustomerNewLocker(CustomerLocker cust, Locker lock) {
		// For customers preferring to have a locker
		Session session = HibernateUtil.getSession().openSession();
		Transaction transc = session.beginTransaction();
		session.save(cust);//Due to the cascade type argument of the @OnetoOne annotation saving Customer object will save Locker object
		transc.commit();
		session.close();
	}

	@Override
	public void addNewCustomerNoLocker(CustomerLocker cust) {
		// For customers preferring not to have locker
		Session session = HibernateUtil.getSession().openSession();
		Transaction transc = session.beginTransaction();
		session.save(cust);//Due to the cascade type argument of the @OnetOne annotation saving Customer object will save Locker object
		transc.commit();
		session.close();
	}

}
