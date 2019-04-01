package com.hibernate.loanapp.compositekey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customerloan", schema="hibernate")
public class CustomerLoanCompoPK{
	
	@EmbeddedId
	CustomerLoanPK pk;
	@Column(name="availedamount")
	private double availedAmount;
	@Column(name="eligibleamount")
	private double eligibleAmount;
	@Column(name="tenureinyears")
	private double tenureInYears;
	
	public CustomerLoanCompoPK(){
		
	}
	
	public CustomerLoanCompoPK(CustomerLoanPK pk, double availedAmount, double eligibleAmount, double tenureInYears) {
		super();
		this.pk = pk;
		this.availedAmount = availedAmount;
		this.eligibleAmount = eligibleAmount;
		this.tenureInYears = tenureInYears;
	}
	public CustomerLoanPK getPk() {
		return pk;
	}
	public void setPk(CustomerLoanPK pk) {
		this.pk = pk;
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
	@Override
	public String toString() {
		return "CustomerLoanCompoPK [pk=" + pk + ", availedAmount=" + availedAmount + ", eligibleAmount="
				+ eligibleAmount + ", tenureInYears=" + tenureInYears + "]";
	}
	
	

}