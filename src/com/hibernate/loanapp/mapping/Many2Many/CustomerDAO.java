package com.hibernate.loanapp.mapping.Many2Many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.crud.HibernateUtil;

public class CustomerDAO implements MtoMCustomer {

	@Override
	public void newPackageNewCustomer(GymCustomer customer, GymPackage gymPackage) {
		List<GymPackage> gymPackages = new ArrayList<GymPackage>();
		gymPackages.add(gymPackage);
		customer.setGymPackage(gymPackages);
		Session session = HibernateUtil.getSession().openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		session.save(customer);
		trans.commit();
		session.close();
	}

	
	@Override
	public void newPackagetExistingCustomer(int customerId, GymPackage gymPackage) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction trans = session.getTransaction();
		GymCustomer customer = (GymCustomer) session.get(GymCustomer.class, customerId);
		List<GymPackage> gymPackages = (List<GymPackage>) customer.getGymPackage();
		if(gymPackages!=null){
			gymPackages.add(gymPackage);
		}else{
			gymPackages = new ArrayList<GymPackage>();
			gymPackages.add(gymPackage);
			customer.setGymPackage(gymPackages);
		}
		trans.begin();
		session.save(customer);
		trans.commit();
		session.close();
	}

}
