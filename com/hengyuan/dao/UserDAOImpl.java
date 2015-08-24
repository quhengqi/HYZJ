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
import com.hengyuan.vo.Order;
import com.hengyuan.vo.User;

public class UserDAOImpl implements IUserDAO {
	private Connection conn;
	public UserDAOImpl(){
		conn=DB.getConnection();

	}
	public User Login(User user) {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		User u=null;
		ResultSet rs=null;
		try {
			String sql="call query_account(?,?)";
			cs=conn.prepareCall(sql);
			cs.setString(1,user.getUsername()); 
			cs.setString(2,user.getPassword());
			rs=cs.executeQuery();
			while(rs.next()){	
				u=new User();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setId(rs.getInt("ID"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				rs.close();
				cs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}

		}	
		return u;
	}
	@Override
	public boolean register(User user) {
		CallableStatement cs=null;
		boolean flag=false;
		try {
			String sql="call add_user(?,?,?,?)";
			cs=conn.prepareCall(sql);
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			cs.setString(3, user.getCellPhoneNumber());
			cs.setString(4, user.getEmail());
			flag=cs.executeUpdate()>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	public User query(User user) {
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
			String sql="call query_user(?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1,user.getId());
			rs=cs.executeQuery();
			while(rs.next()){
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setMoney(rs.getDouble("money"));
				user.setCostmoney(rs.getDouble("costmoney"));
				user.setCellPhoneNumber(rs.getString("cellphone"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				cs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
		return user;
	}
	public boolean pay(User user){
		CallableStatement cs=null;
		boolean flag=false;
		ResultSet rs=null;
		try {
			String sql="call pay_car(?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, user.getId());
			rs=cs.executeQuery();
			while(rs.next()){
				flag=rs.getString("status").equals("true")?true:false;
			}
		} catch (Exception e) {
			/*
			 * e.printStackTrace();
			 * 购物车为空执行支付操作会报异常，但是不影响运行
			 * */
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> ulist=new ArrayList<User>();
		CallableStatement cs=null;
		ResultSet rs=null;
		User u=null;
		try {
			String sql="call query_all_user()";
			cs=conn.prepareCall(sql);
			rs=cs.executeQuery();			
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("ID"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setCellPhoneNumber(rs.getString("cellphone"));
				u.setMoney(rs.getDouble("money"));
				u.setCostmoney(rs.getDouble("costmoney"));
				ulist.add(u);
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
		
		return ulist;
	}
	public boolean delete(User user){
		CallableStatement cs=null;
		boolean flag=false;
		try {
			String sql="call del_user(?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, user.getId());
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
	public List<Order> queryHistory(User user) {
		List<Order> olist=new ArrayList<Order>();
		CallableStatement cs=null;
		ResultSet rs=null;
		Order o=null;
		try {
			String sql="call query_history(?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, user.getId());
			rs=cs.executeQuery();
			while(rs.next()){
				o=new Order();
				o.getGood().setPrice(rs.getDouble("price"));
				o.getGood().setName(rs.getString("name"));
				o.getGood().setQuantity(rs.getInt("quantity"));
				o.setId(rs.getInt("id"));
				o.setDate(rs.getString("date"));
				olist.add(o);
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
		// TODO Auto-generated method stub
		return olist;
	}
}
