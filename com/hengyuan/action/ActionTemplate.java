package com.hengyuan.action;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hengyuan.vo.Order;
import com.hengyuan.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Action模板类
 * 包含Session,User
 * */
public class ActionTemplate extends ActionSupport implements SessionAware {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -4869952403568199734L;
	
	public static final String ALL_USER_IN_CACHE = "allUser";
	
	public static final String USER = "user";
	
	/**
	 * 用户链表缓存
	 * */
	public static Map<String , List<User>> userCache = new HashMap<String , List<User>>();
	/**
	 * 订单缓存链表
	 * */
	public static Map<String , List<Order>> orderCache = new HashMap<String , List<Order>>();
	/**
	 * 获取全局session
	 * */
	private Map<String , Object> session = ActionContext.getContext().getSession();
	/**
	 * 用户容器
	 * */
	private User user;
	/**
	 * 合并Session
	 * */
	/**
	 * 记录所有用户是否被修改
	 * 如果有改动则重新加载
	 * 否则从现有缓存中提取
	 * */
	private boolean allUserIsModify = false;
	
	public void setAllUserIsModify(boolean allUserIsModify) {
		this.allUserIsModify = allUserIsModify;
	}
	public boolean allUserIsModified(){
		return allUserIsModify == Boolean.TRUE;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session.putAll(session);
	}
	public Map<String , Object> getSession(){
		return this.session;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
