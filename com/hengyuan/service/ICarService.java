package com.hengyuan.service;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.vo.Good;

public interface ICarService {
	public List<Good> query(int userid);
	public boolean addgood(int userid,Good good);
	public void delgood(int userid,Good good);
}
