package com.hengyuan.dao;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.vo.Category;
import com.hengyuan.vo.Good;
import com.hengyuan.vo.User;

public interface IGoodDAO {
	public List<Good> queryGoodList(Category category);//获取相应种类的商品链表
	public Good queryGood(Good good);//获取商品的详细信息
	public List<Good> queryWishList(User user);//查询用户收藏
	public boolean addToWishList(User user,Good good);//添加收藏
	public boolean delFromWishList(User user,Good good);//添加收藏
	public List<Good> searchGoodList(String keyWord);//查询商品
}
