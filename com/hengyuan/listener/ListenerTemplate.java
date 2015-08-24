package com.hengyuan.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hengyuan.vo.Category;

public interface ListenerTemplate {
	
	public final static String CATEGORY_LIST = "catlist";
	//是否每次都从数据库中读取Category
	public boolean reloadCategoryFromDB = true;
	
	public static Map<String , List<Category>> categoryCache = new HashMap<String , List<Category>>();
}
