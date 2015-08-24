package com.hengyuan.service;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.dao.CatDAOImpl;
import com.hengyuan.vo.Category;

public class CatServiceImpl implements ICatService {
	private CatDAOImpl catDao;
	public void setCatDao(CatDAOImpl catDao) {
		this.catDao = catDao;
	}
	@Override
	public List<Category> queryCategory() {
		// TODO Auto-generated method stub
		return catDao.queryCategory();
	}

}
