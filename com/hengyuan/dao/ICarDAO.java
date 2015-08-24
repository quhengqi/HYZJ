package com.hengyuan.dao;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.vo.Good;

public interface ICarDAO {
public List<Good> query(int userid);//查询用户购物车
public boolean addgood(int userid,Good good);//用户添加商品
public void delgood(int userid,Good good);//用户删除商品
}
