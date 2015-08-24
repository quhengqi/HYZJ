package com.hengyuan.service;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.dao.GoodDAOImpl;
import com.hengyuan.vo.Category;
import com.hengyuan.vo.Good;
import com.hengyuan.vo.User;

public class GoodServiceImpl implements IGoodService {
	private GoodDAOImpl goodDao;
	public void setGoodDao(GoodDAOImpl goodDao) {
		this.goodDao = goodDao;
	}
	@Override
	public List<Good> queryGoodList(Category category) {
		// TODO Auto-generated method stub
		return goodDao.queryGoodList(category);
	}
	@Override
	public Good queryGood(Good good) {
		// TODO Auto-generated method stub
		return goodDao.queryGood(good);
	}
	@Override
	public List<Good> queryWishList(User user) {
		// TODO Auto-generated method stub
		return goodDao.queryWishList(user);
	}
	
	public boolean addToWishList(User user,Good good){
		 return goodDao.addToWishList(user, good);
	}
	@Override
	public boolean delFromWishList(User user, Good good) {
		// TODO Auto-generated method stub
		return goodDao.delFromWishList(user, good);
	}
	@Override
	public List<Good> searchGoodList(String keyWord) {
		// TODO Auto-generated method stub
		return goodDao.searchGoodList(keyWord);
	}

}
