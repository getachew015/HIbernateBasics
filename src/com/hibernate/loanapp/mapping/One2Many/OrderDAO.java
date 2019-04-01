package com.hibernate.loanapp.mapping.One2Many;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.crud.HibernateUtil;

public class OrderDAO implements OneToManyCustomer {

	@Override
	public void addOrderNewCustomer(CustomerOrder customer, List<OrderCustomer> orderList) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
		session.close();
	}

	@Override
	public void addOrderExistingCustomer(int customerId, List<OrderCustomer> orderList) {
		// Adding multiple or single order per customer
		Session session = HibernateUtil.getSession().openSession();
		CustomerOrder customer = session.get(CustomerOrder.class, customerId);
		customer.setOrderList(orderList);
		Transaction trans = session.beginTransaction();
		session.save(customer);//Customer details will be saved automagically to the order table
		trans.commit();
		session.close();
		
	}

}
