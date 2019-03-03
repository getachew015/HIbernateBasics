package com.hibernate.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HB_JavaBased_Config {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		try {
			Configuration configuration = new Configuration();
			//Hibernate properties equivalent for hbm.cfg.xml settings
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "1308@Dag");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(CustomerWithAnnotation.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

}
