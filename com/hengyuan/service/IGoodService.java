package com.hengyuan.service;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.vo.Category;
import com.hengyuan.vo.Good;
import com.hengyuan.vo.User;

public interface IGoodService {
	public List<Good> queryGoodList(Category category);
	public Good queryGood(Good good);
	public List<Good> queryWishList(User user);
	public boolean addToWishList(User user,Good good);
	public boolean delFromWishList(User user,Good good);
	public List<Good> searchGoodList(String keyWord);
}
