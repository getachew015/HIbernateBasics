package com.hibernate.loanapp.compositekey;

public interface CPKCustomerDAO {
	
	public int addCustomerLoanDetails(CustomerLoan customerLoan);
	public CustomerLoan getCustomerLoanDetails(Integer customerId, String loanId);
	public int addCustomerLoanEmbedded(CustomerLoanCompoPK custLoanCompoPK);
	public CustomerLoanCompoPK getCustomerLoanCompoPK(CustomerLoanPK pk);
}
