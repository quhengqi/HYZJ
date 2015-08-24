package com.hengyuan.vo;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import java.io.Serializable;


public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2733672328975406479L;
	private Good good=new Good();
	private int id;
	private String date;
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
