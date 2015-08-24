package com.hengyuan.interceptor;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import com.hengyuan.action.UserAction;
import com.hengyuan.vo.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	/**
	 * 登录验证拦截器
	 */
	private static final long serialVersionUID = 4310786072344514559L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) invocation.getInvocationContext().getSession().get("user");
		if(user != null)
		{
			return invocation.invoke();
		}
		return UserAction.LOGIN;
	}
	public String getIncludeMethods() {
		return includeMethods;
	}
	public void setIncludeMethods(String includeMethods) {
		this.includeMethods = includeMethods;
		super.setIncludeMethods(includeMethods);
	}
	public String getExcludeMethods() {
		return excludeMethods;
	}
	public void setExcludeMethods(String excludeMethods) {
		this.excludeMethods = excludeMethods;
		super.setExcludeMethods(excludeMethods);
	}
	private String includeMethods;
	private String excludeMethods;
	
	
}
