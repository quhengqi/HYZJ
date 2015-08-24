package com.hengyuan.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;






import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hengyuan.dao.ICatDAO;
import com.hengyuan.vo.Category;

public class CategoryInitListener implements ServletContextListener,ListenerTemplate {
	//category状态是否被修改
	private boolean categoryIsModify = false;
	public ServletContext context;
	public ApplicationContext ctx;
	public boolean isCategoryIsModify() {
		return categoryIsModify == Boolean.TRUE;
	}
	public void setCategoryIsModify(boolean categoryIsModify) {
		this.categoryIsModify = categoryIsModify;
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//获取servlet上下文文件
		context= event.getServletContext();
		ctx =WebApplicationContextUtils.
				getRequiredWebApplicationContext(context);
		if(reloadCategoryFromDB){
			reloadFromDB();
		} else if (isCategoryIsModify()) {
			reloadFromDB();
		} else {
			loadFromCache();
		}
		
	}
	private void loadFromCache() {
		//从缓存中加载商品种类链表
		context.setAttribute(CATEGORY_LIST,categoryCache.get(CATEGORY_LIST));
		
	}
	private void reloadFromDB() {
		System.out.println("从数据库重新加载category资源");
		//移除缓存中原有的商品种类缓存
		categoryCache.remove(CATEGORY_LIST);
		//移除全局资源文件中原有的商品种类缓存
		context.removeAttribute(CATEGORY_LIST);
		//获取服务
		ICatDAO icd=(ICatDAO) ctx.getBean("catDao");
		//查询商品种类
		List<Category> temp = icd.queryCategory();
		//添加到全局资源文件中
		context.setAttribute(CATEGORY_LIST,temp);
		//添加到缓存中
		categoryCache.put(CATEGORY_LIST, temp);
	}
	
}
