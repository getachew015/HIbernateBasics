package com.hibernate.loanapp.compositekey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/*
 * Implementation of the composite primary key using @IdClass annotation
*/

@Entity
@IdClass(CustomerLoanPK.class)
@Table(name="customerloan", schema="hibernate")
public class CustomerLoan {
	
	@Id
	@Column(name="customerid")
	private Integer customerId;
	@Id
	@Column(name="loanid")
	private String loanId;
	@Column(name="availedamount")
	private double availedAmount;
	@Column(name="eligibleamount")
	private double eligibleAmount;
	@Column(name="tenureinyears")
	private double tenureInYears;

	public CustomerLoan(){
		
	}
	public CustomerLoan(Integer customerId, String loanId, double availedAmount, 
			double eligibleAmount, double tenureInYears) {
		super();
		this.customerId = customerId;
		this.loanId = loanId;
		this.availedAmount = availedAmount;
		this.eligibleAmount = eligibleAmount;
		this.tenureInYears = tenureInYears;
	}
	public Integer getCustomerId() {
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
	public double getAvailedAmount() {
		return availedAmount;
	}
	public void setAvailedAmount(double availedAmount) {
		this.availedAmount = availedAmount;
	}
	public double getEligibleAmount() {
		return eligibleAmount;
	}
	public void setEligibleAmount(double eligibleAmount) {
		this.eligibleAmount = eligibleAmount;
	}
	public double getTenureInYears() {
		return tenureInYears;
	}
	public void setTenureInYears(double tenureInYears) {
		this.tenureInYears = tenureInYears;
	}

}
