package com.hibernate.autogeneration;

import java.time.LocalDate;
import java.util.Scanner;

public class ClientCode {

	public static void main(String[] args) {
		/*
		 * A client code to implement auto generated primary key using "increment" strategy
		 * 
		 */
		// TODO Auto-generated method stub
		ProductDAO productdao = new ProductDAO();
		System.out.println("Adding new Product ...");
		Scanner scan = new Scanner(System.in);
		System.out.println("Provide Available Stock ... ");
		int stock = scan.nextInt();
		LocalDate dateCreated = LocalDate.now().minusMonths(13);
		LocalDate dateModified = LocalDate.now().minusMonths(8);
		System.out.println("Provide Product type like Grocery, Diary ... ");
		String productType = scan.next();
		System.out.println("Provide Product SKU number ... ");
		String product_sku = scan.next();
		Product product1 = new Product(stock, dateCreated, dateModified, productType, product_sku);
		productdao.addProduct(product1);
		scan.close();
		
	}

}
