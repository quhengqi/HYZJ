package com.hengyuan.dao;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hengyuan.db.DB;
import com.hengyuan.vo.Category;

public class CatDAOImpl implements ICatDAO {
	private List<Category> catlist=null;
	private Connection conn;
	public CatDAOImpl() {
		// TODO Auto-generated constructor stub
		conn=DB.getConnection();
	}
	public List<Category> queryCategory() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from category";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			catlist=new ArrayList<Category>();
			while(rs.next()){
				Category c=new Category();	
				c.setId(rs.getString("catid"));
				c.setName(rs.getString("catname"));
				catlist.add(c);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return catlist;
	}

}
