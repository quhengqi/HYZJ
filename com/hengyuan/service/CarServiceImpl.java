package com.hengyuan.service;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.util.List;

import com.hengyuan.dao.ICarDAO;
import com.hengyuan.vo.Good;

public class CarServiceImpl implements ICarService {
	ICarDAO carDao;
	public void setCarDao(ICarDAO carDao) {
		this.carDao = carDao;
	}
	@Override
	public List<Good> query(int userid) {
		// TODO Auto-generated method stub
		return carDao.query(userid);
	}
	@Override
	public boolean addgood(int id, Good good) {
		// TODO Auto-generated method stub
		return carDao.addgood(id, good);
	}
	@Override
	public void delgood(int id, Good good) {
		// TODO Auto-generated method stub
		carDao.delgood(id, good);
	}

}
