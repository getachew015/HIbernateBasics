package com.hibernate.loanapp.mapping.Many2Many;

import java.time.LocalDate;
import java.util.Scanner;

public class MtoMUtil {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Provide Your choice New/Existing Customer (N/E)");
		char choice = scan.next().toString().charAt(0);
		switch (choice) {
			case 'N':{
				newCustomer(scan);				
				break;
			}
			case 'E':{
				existingCustomer(scan);
				break;
			}
			default:
				break;
		}
		
		
	}
	
	public static void newCustomer(Scanner sc){
		GymPackage gymPackage = new GymPackage();
		GymCustomer customer = new GymCustomer();
		CustomerDAO customerDao  = new CustomerDAO();
		System.out.println("Provide CustomerId ..");
		customer.setCustomerid(sc.nextInt());
		sc.nextLine();
		System.out.println("Provide Customer Name");
		customer.setName(sc.nextLine());
		System.out.println("Provide Customer Date Of Birth");
		customer.setDate(LocalDate.parse(sc.next()));
		System.out.println("Provide Package Id");
		gymPackage.setPackageid(sc.nextInt());
		sc.nextLine();
		System.out.println("Provide package type");
		gymPackage.setPackageType(sc.nextLine());
		System.out.println("Package Features");
		gymPackage.setPackageFeatures(sc.nextLine());
		customerDao.newPackageNewCustomer(customer, gymPackage);
	}
	
	public static void existingCustomer(Scanner sc){
		GymPackage gymPackage = new GymPackage();
		CustomerDAO customerDao  = new CustomerDAO();
		System.out.println("Provide CustomerId ..");
		int id = sc.nextInt();
		System.out.println("Provide Package Id");
		gymPackage.setPackageid(sc.nextInt());
		sc.nextLine();
		System.out.println("Provide package type");
		gymPackage.setPackageType(sc.nextLine());
		System.out.println("Package Features");
		gymPackage.setPackageFeatures(sc.nextLine());
		customerDao.newPackagetExistingCustomer(id, gymPackage);
		
	}

}
