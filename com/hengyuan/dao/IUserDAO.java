package com.hengyuan.dao;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.vo.Order;
import com.hengyuan.vo.User;

public interface IUserDAO {
public User Login(User user);//登陆
public boolean register(User user);//注册
public User query(User user);//查询
public boolean pay(User user);//付款
public List<User> queryAll();//查询所有用户
public boolean delete(User user);//删除用户
public List<Order> queryHistory(User user);//查询消费记录
}
