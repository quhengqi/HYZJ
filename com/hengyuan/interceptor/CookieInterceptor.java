package com.hengyuan.interceptor;

import java.util.Map;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;

import com.hengyuan.dao.IUserDAO;
import com.hengyuan.vo.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CookieInterceptor implements Interceptor, SessionAware ,CookiesAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	private Map<String, String> cookie;

	private IUserDAO iud;
	public IUserDAO getIud() {
		return iud;
	}

	public void setIud(IUserDAO iud) {
		this.iud = iud;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		if(!cookie.get("username").equals("") && !cookie.get("password").equals("")){
			User user =iud.Login(new User(cookie.get("username"),cookie.get("password")));
			session.put("user", user);
		}
		return invocation.invoke();
	}

	@Override
	public void setCookiesMap(Map<String, String> cookie) {
		// TODO Auto-generated method stub
		this.cookie = cookie;
	}

}
