package com.hengyuan.dao;
/**
 * author:quhengqi
 * version:1.0
 * 
 */
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hengyuan.db.DB;
import com.hengyuan.vo.Category;
import com.hengyuan.vo.Good;
import com.hengyuan.vo.User;

public class GoodDAOImpl implements IGoodDAO {
	private List<Good> gl=null;
	private Connection conn;
	public GoodDAOImpl(){
		conn=DB.getConnection();
	}
	public List<Good> queryGoodList(Category category) {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
			String sql="call query_page(?,?)";
			cs=conn.prepareCall(sql);
			cs.setString(1, category.getId());
			cs.setInt(2,category.getPagenum());
			rs=cs.executeQuery();
			gl=new ArrayList<Good>();
			while(rs.next()){
				Good gd=new Good();	
				gd.setId(rs.getInt("id"));
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getDouble("price"));
				gd.setIDnumber(rs.getString("number"));
				gl.add(gd);
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
		return gl;
	}
	@Override
	public Good queryGood(Good good) {
		CallableStatement cs=null;
		Good gd=null;
		ResultSet rs=null;
		// TODO Auto-generated method stub
		try {
			String sql="call query_good(?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, good.getId());
			rs=cs.executeQuery();
			while(rs.next()){
				gd=new Good();
				gd.setId(rs.getInt("ID"));
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getDouble("price"));
				gd.setIDnumber(rs.getString("number"));
				gd.setDescnb(rs.getString("descn_1"));
				gd.setDescns(rs.getString("descn_2"));
				gd.setStatus(rs.getString("status"));
				gd.setQuantity(rs.getInt("quantity"));
				gd.setIntr(rs.getString("intr"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gd;
	}
	@Override
	public List<Good> queryWishList(User user) {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		Good gd=null;
		ResultSet rs=null;
		gl=new ArrayList<Good>();
		try {
			String sql="call query_wishlist(?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, user.getId());
			rs=cs.executeQuery();
			while(rs.next()){
				gd=new Good();
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getDouble("price"));
				gd.setIDnumber(rs.getString("number"));
				gd.setDescns(rs.getString("descn_2"));	
				gd.setId(rs.getInt("id"));
				gl.add(gd);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gl;
	}
	public boolean addToWishList(User user,Good good){
		CallableStatement cs=null;
		boolean flag=false;
		try {
			String sql="call add_good_to_wishlist(?,?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, user.getId());
			cs.setInt(2, good.getId());
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
	public boolean delFromWishList(User user, Good good) {
		// TODO Auto-generated method stub
		CallableStatement cs=null;
		boolean flag=false;
		try {
			String sql="call del_good_from_wishlist(?,?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, user.getId());
			cs.setInt(2, good.getId());
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
	public List<Good> searchGoodList(String keyWord) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		gl=new ArrayList<Good>();
		try {
			String sql= "select * from good g where g.name like ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyWord+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Good gd=new Good();	
				gd.setId(rs.getInt("id"));
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getDouble("price"));
				gd.setIDnumber(rs.getString("number"));
				gl.add(gd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return gl;
	}
}
