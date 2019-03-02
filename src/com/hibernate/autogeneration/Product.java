package com.hibernate.autogeneration;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
create table if not exists hibernate.product
(product_id integer,  date_created date, date_modified date, 
product_type varchar(500), sku varchar(500), stock_available integer, 
primary key(product_id) );
 */

@Entity
@Table(name = "producttbl", schema="hibernate" )
@GenericGenerator(name="gen", strategy = "increment")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="gen" )
	@Column(name="product_id")
	private int product_id;
	@Column(name = "stock_available")
	private int stock_available;
	@Column(name="date_created")
	private LocalDate date_created; 
	@Column(name="date_modified")
	private LocalDate date_modified;
	@Column(name="product_type")
	private String product_type; 
	@Column(name="sku")
	private String sku;
	
	public Product(){
		
	}
	public Product(int stock_available, LocalDate date_created, LocalDate date_modified,
			String product_type, String sku) {
		super();
		this.stock_available = stock_available;
		this.date_created = date_created;
		this.date_modified = date_modified;
		this.product_type = product_type;
		this.sku = sku;
	}
	public Product(int product_id, int stock_available, LocalDate date_created, LocalDate date_modified,
			String product_type, String sku) {
		super();
		this.product_id = product_id;
		this.stock_available = stock_available;
		this.date_created = date_created;
		this.date_modified = date_modified;
		this.product_type = product_type;
		this.sku = sku;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getStock_available() {
		return stock_available;
	}
	public void setStock_available(int stock_available) {
		this.stock_available = stock_available;
	}
	public LocalDate getDate_created() {
		return date_created;
	}
	public void setDate_created(LocalDate date_created) {
		this.date_created = date_created;
	}
	public LocalDate getDate_modified() {
		return date_modified;
	}
	public void setDate_modified(LocalDate date_modified) {
		this.date_modified = date_modified;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", stock_available=" + stock_available + ", date_created="
				+ date_created + ", date_modified=" + date_modified + ", product_type=" + product_type + ", sku=" + sku
				+ "]";
	}
		
}
