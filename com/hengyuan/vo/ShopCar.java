package com.hengyuan.vo;
/**
 * author:quhengqi
 * version:2.0
 * 
*/
import java.io.Serializable;

public class ShopCar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2707929051321615122L;
	private int id;
	private Good good;
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

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
}
