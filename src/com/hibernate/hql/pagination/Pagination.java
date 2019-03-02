package com.hibernate.hql.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.crud.HibernateUtil;
import com.hibernate.crud.OrderTbl;

public class Pagination {
	/*
	 * list() consumes only one single bulk n/w call, retrieves all records into bean instances, 
	 * hence it consumes more heap memory.
	   iterate() consumes more n/w calls (number of records + 1) and required heap memory 
	   (as many object as we fetch from Iterator).
	   The intemediatery solution to fetch all the records with less n/w calls, 
	   Query interface provided methods for pagination. 
	   The methods are setFirstResult(int recordno) and setMaxResults(int maxpagesize).
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession().openSession();
		Query query = session.createQuery("from OrderTbl o where o.productQuantity > 5");
		//setting the maxResult to 4 forces list to fetch only 4 records
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<OrderTbl> list = query.list();
		list.forEach(order -> System.out.println(order.toString()));
		query.setFirstResult(4);
		list = query.list();
		list.forEach(order -> System.out.println(order.toString()));
		/*
		Even pagination also consumes more n/w calls one more solution is to implement caching in hibernate.
		 */
	}

}
