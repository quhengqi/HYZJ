package com.hengyuan.dao;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hengyuan.db.DB;
import com.hengyuan.vo.Good;


public class CarDAOImpl implements ICarDAO {
	private Connection conn;
	private List<Good> clist;
	public CarDAOImpl(){
		conn=DB.getConnection();
	}
	@Override
	public List<Good> query(int userid) {
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
			String sql="call query_car(?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, userid);
			rs=cs.executeQuery();
			clist=new ArrayList<Good>();
			while(rs.next()){
				Good gd=new Good();	
				gd.setIDnumber(rs.getString("number"));
				gd.setDescns(rs.getString("descn_2"));
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getDouble("price"));
				gd.setAmount(rs.getDouble("amount"));
				gd.setQuantity(rs.getInt("quantity"));
				gd.setId(rs.getInt("id"));
				clist.add(gd);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clist;
	}
	public boolean addgood(int userid,Good good) {
		CallableStatement cs=null;
		boolean flag=false;
		try {
			String sql="call add_good(?,?,?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, userid);
			cs.setInt(2, good.getId());
			cs.setInt(3, good.getQuantity());
			flag=cs.executeUpdate()>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public void delgood(int userid, Good good) {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		try {
			String sql="call del_good(?,?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, good.getId());
			cs.setInt(2, userid);
			cs.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
