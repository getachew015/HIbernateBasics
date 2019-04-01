package com.hibernate.loanapp.mapping.one2one;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomerLockerUtil {

	public static void main(String[] args) {
		// User Interaction
		Scanner scan = new Scanner(System.in);
		CustomerDAO customerDao = new CustomerDAO();
		CustomerLocker customer = new CustomerLocker();
		Locker locker = new Locker();
		System.out.println("Provide CustomerId .... ");
		customer.setCustomerid(scan.nextInt());
		scan.nextLine();
		System.out.println("Provide Customer Name .... ");
		customer.setCustomername(scan.nextLine());
		System.out.println("Provide Date Of Birth mm/dd/yyyy... ");
		customer.setDateofbirth(LocalDate.now().minusYears(45));
		System.out.println("Provide Address ...");
		customer.setAddress(scan.nextLine());
		System.out.println("Provide Phone Number ...");
		customer.setPhonenumber(scan.nextLine());
		System.out.println("Does Customer want Locker? Y/N");
		String lock = scan.nextLine();
		if(lock.equalsIgnoreCase("y")){
			System.out.println("Provide Locker ID ...");
			locker.setLockerid(scan.nextLine());
			System.out.println("Provide Locker Type ...");
			locker.setLockertype(scan.nextLine());
			System.out.println("Provide rent amount ...");
			locker.setRent(scan.nextInt());
			customer.setLocker(locker);
			customerDao.addNewCustomerNewLocker(customer, locker);
			System.out.println("**** Record Added ****");
		}else{
			customerDao.addNewCustomerNoLocker(customer);
			System.out.println("*** Record Added ***");
		}
		scan.close();
	}

}
