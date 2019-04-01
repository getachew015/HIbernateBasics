package com.hibernate.loanapp.mapping.Many2Many;

public interface MtoMCustomer {
	
	public void newPackageNewCustomer(GymCustomer customer, GymPackage gymPackage);
	public void newPackagetExistingCustomer(int customerId, GymPackage gymPackage);	

}
