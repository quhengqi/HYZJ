package com.hengyuan.db;
/**
 * author:quhengqi
 * version:1.0
 * 
*/
import java.io.File;
import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DB {
		private static DruidPooledConnection conn;
		private static Properties pro=new Properties();
		static {
			readIn();
		}
		public static DruidPooledConnection readIn(){
			File file=new File(DB.class.getClassLoader().getResource("").getPath()+"druid.ini");
			try{
				pro.load(new FileInputStream(file));
				conn=((DruidDataSource)DruidDataSourceFactory.createDataSource(pro)).getConnection();
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;
		}
		public static DruidPooledConnection getConnection(){
			return conn;
		}
	//	public static void main(String[] args) {
	//		new DB();
	//		System.out.println(DB.getConnection());
	//	}
//	public static Connection getConnection(){
//		Connection conn=null;
//
//		try {
//			Class.forName("org.gjt.mm.mysql.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HYUser?"
//					+ "useUnicode=true&characterEnicoding=utf-8", "root", "root");		
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
}	
