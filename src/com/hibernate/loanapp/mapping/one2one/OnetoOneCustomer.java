package com.hibernate.loanapp.mapping.one2one;

public interface OnetoOneCustomer {
	public void addNewCustomerNewLocker(CustomerLocker cust, Locker lock);
	public void addNewCustomerNoLocker(CustomerLocker cust);
}
