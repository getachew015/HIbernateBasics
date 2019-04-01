package com.hibernate.loanapp.mapping.One2Many;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderCustomerUtil {
	
	public static void main(String args[]){		
		Scanner scan = new Scanner(System.in);
		System.out.println("Is this new customer Y/N?");
		char register = scan.next().toString().charAt(0);
			switch (register) {
				case 'Y':{
					newCustomer(scan);
					break;
				}
				case 'N':{
					existingCustomer (scan);
					break;
				}
				default:{
					scan.close();
					break;
				}
			}
		}
	
	public static void newCustomer(Scanner scan){
		CustomerOrder customer = new CustomerOrder();
		List<OrderCustomer> orderList = new ArrayList<OrderCustomer>();
		OrderCustomer order = new OrderCustomer();
		OrderDAO orderDao = new OrderDAO();
		System.out.println("Provide Customer Id ..");
		customer.setCustomerId(scan.nextInt());
		scan.nextLine();
		System.out.println("Provide Customer Address ..");
		customer.setAddress(scan.nextLine());
		System.out.println("Provide Customer Phone");
		customer.setPhoneNumber(scan.nextLine());
		System.out.println("How Many Order Do you want to place?");
		int orderQty = scan.nextInt();
		int counter=0;
		while(counter < orderQty){
			System.out.println("You are on Order Num - "+counter);
			System.out.println("Provide Order Id");
			order.setOrderId(scan.next());
			System.out.println("Provide Product Id");
			order.setProductId(scan.next());
			scan.nextLine();
			System.out.println("Provide Product Name");
			order.setProductName(scan.nextLine());
			System.out.println("Provide Quantity");
			order.setProductQuantity(scan.next());
			orderList.add(order);
			counter++;
		}
			customer.setOrderList(orderList);
			orderDao.addOrderNewCustomer(customer, orderList);
		}
	public static void existingCustomer(Scanner scan){
		List<OrderCustomer> orderList = new ArrayList<OrderCustomer>();
		OrderCustomer order = new OrderCustomer();
		OrderDAO orderDao = new OrderDAO();
		System.out.println("Provide customer id");
		int customerId = scan.nextInt();
		System.out.println("How Many Order Do you want to place?");
		int orderQty = scan.nextInt();
		int counter=0;
		while(counter < orderQty){
			System.out.println("You are on Order Num - "+counter);
			System.out.println("Provide Order Id");
			order.setOrderId(scan.next());
			System.out.println("Provide Product Id");
			order.setProductId(scan.next());
			scan.nextLine();
			System.out.println("Provide Product Name");
			order.setProductName(scan.nextLine());
			System.out.println("Provide Quantity");
			order.setProductQuantity(scan.next());
			orderList.add(order);
			counter++;
		}
		orderDao.addOrderExistingCustomer(customerId, orderList);	
		}
	}
