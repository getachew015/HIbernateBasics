package com.hibernate.nativesql;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.hibernate.crud.HibernateUtil;
import com.hibernate.crud.OrderTbl;

public class Hibernate_NativeSQL_Demo {

/*
Native SQL is SQL in the native format of the database you are connected to, 
for performing operations like create, update, delete and select.
To work with Native SQL Query mechanism:
•	Use createSQLQuery() method of session Object to pass the query string.
•	It returns a org.hibernate.SQLQuery object.
•	Invoke the list() to get the data from the selected database table
With this migration from JDBC to Hibernate can be achieved easily. 
However, Native SQL Query Mechanism has some disadvantages. 
•	It might cause portability issues.
•	No Object Oriented feature is used. 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession().openSession();
		Query query = session.createSQLQuery("select o.productid, o.productname, "
				+ "o.productquantity from hibernate.ordertbl o order by productid;");
		List<Object[]> orderList = query.getResultList();
		orderList.stream().forEach(order -> {System.out.println("ProductName: "+order[1]);
			String productID = (String)order[0];});
	}

}
