package com.hengyuan.dao;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.vo.Category;

public interface ICatDAO {
	public List<Category> queryCategory();//获取商品种类链表
}
