package com.hengyuan.vo;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import java.io.Serializable;


public class Good implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3176787230982041980L;
	private String name;
	private String category;
	private String descnb;
	private String descns;
	private String orderid;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getDescns() {
		return descns;
	}
	public void setDescns(String descns) {
		this.descns = descns;
	}
	private String intr;
	public String getIntr() {
		return intr;
	}
	public void setIntr(String intr) {
		this.intr = intr;
	}
	public String getDescnb() {
		return descnb;
	}
	public void setDescnb(String descnb) {
		this.descnb = descnb;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private double price;
	private String IDnumber;
	private String status;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private int quantity;
	private int id;
	private double amount;
	public String getIDnumber() {
		return IDnumber;
	}
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
