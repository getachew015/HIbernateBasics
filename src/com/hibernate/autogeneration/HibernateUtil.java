package com.hibernate.autogeneration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static {
		try {
			Configuration configuration = new Configuration().configure("hbm.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			// Exceptions caught here
			e.printStackTrace();
			System.out.println("Session Factory Creation Failed ...");
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
