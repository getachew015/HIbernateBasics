package com.hibernate.loanapp.compositekey;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerLoanPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String loanId;
	
	public CustomerLoanPK() {
		
	}
	public CustomerLoanPK(Integer customerId, String loanId) {
		super();
		this.customerId = customerId;
		this.loanId = loanId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

}
