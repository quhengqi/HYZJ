package com.hengyuan.action;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import java.util.List;


import com.hengyuan.service.CarServiceImpl;
import com.hengyuan.vo.Good;
import com.hengyuan.vo.User;

/**
 * 实现购物车功能
 * 查看用户购物车
 * 向购物车内添加商品，从购物车中删除商品
 * */
public class CarAction extends ActionTemplate{
	/**
	 * UID
	 */
	private static final long serialVersionUID = -4333580887637131241L;
	/**
	 * 购物车服务类声明
	 * */
	private CarServiceImpl carservice;
	/**
	 * 商品容器
	 * */
	private Good good;
	/**
	 * 购物车商品链表
	 * */
	private List<Good> carlist;

	public CarServiceImpl getCarservice() {
		return carservice;
	}
	public void setCarservice(CarServiceImpl carservice) {
		this.carservice = carservice;
	}
	public List<Good> getCarlist() {
		return carlist;
	}
	public void setCarlist(List<Good> carlist) {
		this.carlist = carlist;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	/**
	 * 查看用户购物车
	 * */
	public String showCart() throws Exception {
		setCarlist(carservice.query(((User)getSession().get("user")).getId()));
		return "show";
	}
	/**
	 * 向购物车内添加商品
	 * */
	public String addToCart() throws Exception {
		carservice.addgood(((User)getSession().get("user")).getId(), getGood());//添加到购物车
		return showCart();
	}
	/**
	 * 从购物车内删除商品
	 * */
	public String deleteFromCart() throws Exception {
		// TODO Auto-generated method stub
		carservice.delgood(((User)getSession().get("user")).getId(),getGood());
		return showCart();
	}
}
