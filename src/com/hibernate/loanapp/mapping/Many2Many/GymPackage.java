package com.hibernate.loanapp.mapping.Many2Many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gympackage", schema="hibernate")
public class GymPackage {
	@Id
	@Column(name="packageid")
	private int packageid;
	@Column(name="packagetype")
	private String packageType;
	@Column(name="packagefeatures")
	private String packageFeatures;
	
	public GymPackage(){
		
	}
	public GymPackage(int packageid, String packageType, String packageFeatures) {
		super();
		this.packageid = packageid;
		this.packageType = packageType;
		this.packageFeatures = packageFeatures;
	}
	public int getPackageid() {
		return packageid;
	}
	public void setPackageid(int packageid) {
		this.packageid = packageid;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getPackageFeatures() {
		return packageFeatures;
	}
	public void setPackageFeatures(String packageFeatures) {
		this.packageFeatures = packageFeatures;
	}
	@Override
	public String toString() {
		return "GymPackage [packageid=" + packageid + ", packageType=" + packageType + ", packageFeatures="
				+ packageFeatures + "]";
	}
	
}
