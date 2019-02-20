package com.hibernate.configuration;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerClient_With_JavaBasedConfig {

	public static void main(String[] args) {
		//Get Session object using the javabased config class
		Session session = HB_JavaBased_Config.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		CustomerWithAnnotation customer1 = new CustomerWithAnnotation(1005,"Etiye Entina", LocalDate.now().minusYears(50));
		session.save(customer1);
		trans.commit();
		session.close();
	}

}
