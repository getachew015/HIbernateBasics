package com.hibernate.crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		try {
			/*
				This utility class will be used to get sessionFactory object
			 */
			Configuration configuration = new Configuration().configure("/hbm.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error creating Session factory object ");
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSession(){
		return sessionFactory;
	}
}
