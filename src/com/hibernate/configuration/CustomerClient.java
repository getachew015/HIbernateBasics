package com.hibernate.configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CustomerClient {
	/*
	Steps To Connect To Database Using Hibernate
	Let us discuss the basic steps for a Java application to connect to the database using Hibernate.
		1.	Create an instance of Configuration class and loads hibernate configurations and related mappings.
		2.	Use org.hibernate.service.StandardServiceRegistryBuilder API and create an instance of ServiceRegistry.  
		3.	Use the instance of ServiceRegistry and create the instance of SessionFactory.
	 */
	public static void main(String[] args) {
		//DB Constants for JDBC connection
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/hibernate";
		final String USER_NAME = "root";
		final String PWRD = "1308@Dag";
		//Create a java Bean object
		Customer customer1 = new Customer(1003, "Jeff Bezos", LocalDate.now().minusYears(45));
		Customer customer2 = new Customer(2005, "Mestayit Aragaw", (LocalDate.now().minusYears(29)));
		//congigure() method internally uses xml parsers to read DB properties and DB mapping information 
		Configuration configuration = new Configuration().configure("/hbm.cfg.xml");
		// this method returns session factory object which stores all driver properties and mapping information
		SessionFactory sFactory = configuration.buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction trans = session.beginTransaction();
		try {
			//inorder not to violet the PK rule inset new records each time
			session.update(customer2);
//			session.save(customer2);
			session.flush();
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		//Trying to achieve the above code block using with JDBC
		Connection conn = null;
		Statement statement = null;
		
		try {
			
			Class.forName(JDBC_DRIVER);
			conn = (Connection) DriverManager.getConnection(DB_URL,USER_NAME,PWRD);
			statement = (Statement) conn.createStatement();
			String sql = "select * from hibernate.customer;";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){				
				System.out.println("Name "+resultSet.getString("name"));
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
