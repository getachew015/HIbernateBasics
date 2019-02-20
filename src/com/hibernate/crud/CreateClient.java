package com.hibernate.crud;

import java.util.Scanner;

	/*
		Hibernate persist() is similar to save() (with transaction) for insert operation. 
		However, persist() does not return the identifier(PK value) whereas save() does.
	 */
public class CreateClient {

	public static void main(String[] args) {
		String orderId, productId, productName;
		int quantity;
		System.out.println("Create operation of CRUD ");
		System.out.println("Taking in order Detail Information");
		Scanner scan = new Scanner(System.in);
		int i=0, orderNum=0;
		System.out.println("How Many Orders Do you want to place? ");
		orderNum=scan.nextInt();
		while(i < orderNum){
			System.out.println("Details for Order Number "+i);
			scan.nextLine();
			System.out.println("Provide Order ID e.g ASD1002");
			orderId = scan.nextLine();
			System.out.println("Provide Product ID e.g XN1002");
			productId = scan.nextLine();
			System.out.println("Provide product Name");
			productName = scan.nextLine();
			System.out.println("Provide Order Quantity");
			quantity = scan.nextInt();
			OrderTbl order = new OrderTbl(orderId,productId,productName,quantity);
			OrderDAO orderdao = new OrderDAO();
			orderdao.addOrder(order);
			i++;
		}
			scan.close();
	}
	
}
