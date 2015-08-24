package com.hengyuan.service;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.dao.IUserDAO;
import com.hengyuan.vo.Order;
import com.hengyuan.vo.User;

public class UserServiceImpl implements IUserService {
	IUserDAO userDao;
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}
	@Override
	public User Login(User user) {
		// TODO Auto-generated method stub
		return userDao.Login(user);
	}
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userDao.register(user);
	}
	public User query(User user) {
		// TODO Auto-generated method stub
		return userDao.query(user);
	}
	@Override
	public boolean pay(User user) {
		// TODO Auto-generated method stub
		return userDao.pay(user);
	}
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}
	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return userDao.delete(user);
	}
	@Override
	public List<Order> queryHistory(User user) {
		// TODO Auto-generated method stub
		return userDao.queryHistory(user);
	}

}
