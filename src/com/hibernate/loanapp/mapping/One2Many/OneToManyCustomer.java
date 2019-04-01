package com.hibernate.loanapp.mapping.One2Many;

import java.util.List;

public interface OneToManyCustomer {
	//Many orders can be placed by one customer
	public void addOrderNewCustomer(CustomerOrder customer, List<OrderCustomer> orderList);
	public void addOrderExistingCustomer(int customerId, List<OrderCustomer> orderList);

}
