package com.hengyuan.action;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import java.util.List;
import java.util.Map;

import com.hengyuan.service.UserServiceImpl;
import com.hengyuan.vo.Order;
import com.hengyuan.vo.User;
/**
 * 实现用户操作
 * 用户登录,注销,注册,个人信息查询,付款操作,查询所有用户,删除用户
 * 查看订单记录,修改个人信息;
 * */
public class UserAction extends ActionTemplate{ 
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1838565228433112576L;
	/**
	 * 用户服务类声明
	 * */
	private UserServiceImpl uservice;
	/**
	 * 用户链表，用来存放所有用户信息
	 * */
	private List<User> ulist;
	/**
	 * 订单链表，用来存放相应用户的订单信息
	 * */
	private List<Order> olist;
	/**
	 * 记录订单状态是否被修改
	 * 如果有改动则重新加载
	 * 否则从现有缓存中提取
	 * */
	private boolean orderIsModify = false;
	
	public void setOrderIsModify(boolean orderIsModify) {
		this.orderIsModify = orderIsModify;
	}
	public boolean orderIsModified(){
		return orderIsModify == Boolean.TRUE;
	}
	public static Map<String, List<User>> getUserCache() {
		return userCache;
	}
	public static Map<String, List<Order>> getOrderCache() {
		return orderCache;
	}
	public void setUservice(UserServiceImpl uservice) {
		this.uservice = uservice;
	}
	public List<User> getUlist() {
		return ulist;
	}
	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}
	public List<Order> getOlist() {
		return olist;
	}
	public void setOlist(List<Order> olist) {
		this.olist = olist;
	}
	/**
	 * 用户登录操作实现方法
	 * */
	public String login()throws Exception{
		this.clearMessages();
		setUser(uservice.Login(getUser()));
		if(getUser()==null){
			this.addActionMessage("该用户不存在");
			return "login";
		}
		getSession().put("user",uservice.query(getUser()));
		return "index";
	}
	/**
	 * 用户注册操作实现方法
	 * */
	public String register()throws Exception{
		this.clearMessages();
		if(getUser()!= null){
			if(uservice.register(getUser())==false){
				this.addActionMessage("该用户已存在");
				return "rmain";	

			}
			setAllUserIsModify(true);
			return login();
		}
		return "rmain";
	}
	/**
	 * 查询用户个人信息操作实现方法
	 * */
	public String userInf()throws Exception{
		getSession().put(USER,uservice.query(getUser()));
		return "userInf";
	}
	/**
	 * 用户付款操作实现方法
	 * */
	public String pay()throws Exception{
		this.clearMessages();
		if(uservice.pay(getUser())){
			//设置订单修改状态属性为true
			setOrderIsModify(true);
			this.addActionMessage("支付成功!");
			return "pay";
		}else{
			this.addActionMessage("付款失败，余额不足或购物车内无需付款商品");
			return "pay";
		}
	}
	/**
	 * 查询所有用户操作实现方法
	 * */
	public String queryAll()throws Exception{
		//如果缓存为空  || 所有用户链表被修改
		if(getUserCache().isEmpty() || allUserIsModified()){
			System.out.println("重新从数据库读取用户信息");
			//移除之前的缓存
			getUserCache().remove(ALL_USER_IN_CACHE);
			setUlist(uservice.queryAll());
			//放入新的查询结果到缓存中
			getUserCache().put(ALL_USER_IN_CACHE, getUlist());
			//设置所有用户修改状态属性为false
			setAllUserIsModify(false);
		}
		//缓存不为空且未修改，直接返回缓存中的用户链表
		else{
			setUlist(getUserCache().get(ALL_USER_IN_CACHE));
		}
		return "showUser";

	}
	/**
	 * 删除所有用户方法
	 * */
	public String delete()throws Exception{
		//删除用户
		if(uservice.delete(getUser())){
			setAllUserIsModify(true);
		}
		//设置修改状态标志为true
		return queryAll();
	}
	/**
	 * 用户注销退出登录方法
	 * */
	public String logOff() throws Exception {
		getSession().clear();
		getUserCache().clear();
		getOrderCache().clear();
		return "index";
	}
	/**
	 * 查看用户消费订单记录方法
	 * */
	public String queryHistory() throws Exception{
		//如果订单缓存为空 || 订单被修改
		if(getOrderCache().isEmpty() || orderIsModified()){	
			System.out.println("重新从数据库读取订单信息");
			//移除该用户对应的订单缓存
			getOrderCache().remove(getUser().getUsername());
			//重新查询该用户的订单信息
			setOlist(uservice.queryHistory(getUser()));
			//将新的订单查询结果添加到订单缓存中
			getOrderCache().put(getUser().getUsername(), getOlist());
			//设置订单修改状态属性为false
			setOrderIsModify(false);
		}else{
			//直接从缓存中提取订单信息
			setOlist(getOrderCache().get(getUser().getUsername()));
		}
		return "history";
	}
	/**
	 * 更新用户个人信息方法
	 * */
	public String updateUserInf() throws Exception {
		// TODO Auto-generated method stub
		return "";
	}
}
