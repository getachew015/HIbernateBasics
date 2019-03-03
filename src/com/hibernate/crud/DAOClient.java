package com.hibernate.crud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

	/*
		Hibernate persist() is similar to save() (with transaction) for insert operation. 
		However, persist() does not return the identifier(PK value) whereas save() does.
	 */
public class DAOClient {

	public static void main(String[] args) {
		String orderId, productId, productName;
		int quantity;
		Scanner scan = new Scanner(System.in);
		System.out.println("Type 'C' for Create, 'R' for Read, 'U' for Update and 'D' for Delete");
		char operation = scan.next().trim().charAt(0);
		OrderDAO orderdao = new OrderDAO();
		switch (operation) {
		case 'C':{
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
				orderdao.addOrder(order);
				i++;
			}
			
			break;
		}
		case 'R':{
			System.out.println("Provide Order Id/PK value ");
			orderdao.getOrder(scan.next());
			break;
		}
		case 'U':{
			//Just calling update a couple of times to witness update() vs saveorUpdate() LOL
			OrderTbl order1 = new OrderTbl("ASD3001","XN3001", "Jordan Shoe", 4);
			OrderTbl order2 = new OrderTbl("ASD3002","XN3002", "Motorolla Cell", 2);
			OrderTbl order3 = new OrderTbl("ASD3003","XN3003", "Harley Davidson", 1);
			OrderTbl order4 = new OrderTbl("REW7654","VB4234", "Samsung TV", 2);
			List<OrderTbl> orderRecs = new ArrayList<OrderTbl>();
			orderRecs.add(order1);
			orderRecs.add(order2);
			orderRecs.add(order3);
			orderRecs.add(order4);
			orderRecs.forEach(order -> orderdao.updateOrder(order.getOrderId(), order));			
			break;
		}
		case 'D':{
			System.out.println("Provide Order Id to delete record ");
			orderdao.deleteOrder(scan.next());
			break;
		}
		default:
			break;
		}
			scan.close();
	}
	
}
