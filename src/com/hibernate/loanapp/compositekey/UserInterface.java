package com.hibernate.loanapp.compositekey;

import java.util.Scanner;

public class UserInterface {
	
	public static void main(String args[]){
		/*
			Composite Primary key using @IdClass & @EmbeddedId
		 */
		CustomerDAO customerdao = new CustomerDAO();
		CustomerLoan custLoan = new CustomerLoan();
		CustomerLoanCompoPK custLoanPK = new CustomerLoanCompoPK();
		Scanner scan = new Scanner(System.in);
		char choice=0;
		System.out.println("Enter your choice, I for Idclass and E for EmbeddedId");
		choice=scan.next().toString().charAt(0);
		switch (choice) {
		case 'I':{
			try {
				System.out.println("Provide Customer ID");
				custLoan.setCustomerId(scan.nextInt());
				System.out.println("Provide Loan ID");
				custLoan.setLoanId(scan.next());
				System.out.println("Provide availed amount");
				custLoan.setAvailedAmount(scan.nextDouble());
				System.out.println("Provide Eligible amount");
				custLoan.setEligibleAmount(scan.nextDouble());
				System.out.println("Provide tenure in years");
				custLoan.setTenureInYears(scan.nextDouble());
				customerdao.addCustomerLoanDetails(custLoan);
				scan.close();
			} catch (Exception e) {
				e.printStackTrace();
			}			
			break;
		}
		case 'E':{
			try {
				CustomerLoanPK pk = new CustomerLoanPK();
				System.out.println("Provide Customer ID");
				pk.setCustomerId(scan.nextInt());
				System.out.println("Provide Loan ID");
				pk.setLoanId(scan.next());
				custLoanPK.setPk(pk);
				System.out.println("Provide availed amount");
				custLoanPK.setAvailedAmount(scan.nextDouble());
				System.out.println("Provide Eligible amount");
				custLoanPK.setEligibleAmount(scan.nextDouble());
				System.out.println("Provide tenure in years");
				custLoanPK.setTenureInYears(scan.nextDouble());
				customerdao.addCustomerLoanEmbedded(custLoanPK);
				scan.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		default:
			break;
		}
	}

}
