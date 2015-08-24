package com.hengyuan.service;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.vo.Order;
import com.hengyuan.vo.User;


public interface IUserService{
public User Login(User user);
public boolean register(User user);
public User query(User user);
public boolean pay(User user);
public List<User> queryAll();
public boolean delete(User user);
public List<Order> queryHistory(User user);
}
