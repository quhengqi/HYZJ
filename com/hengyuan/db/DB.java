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
	public static DruidPooledConnection getConnection(){
		return connectionHolder.get();
	}
	private static ThreadLocal<DruidPooledConnection> connectionHolder = new ThreadLocal<DruidPooledConnection>(){
		@Override
		protected DruidPooledConnection initialValue() {
			// TODO Auto-generated method stub
			try{
				pro.load(new FileInputStream(new File(DB.class.getClassLoader().getResource("").getPath()+"druid.ini")));
				conn=((DruidDataSource)DruidDataSourceFactory.createDataSource(pro)).getConnection();
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;
		}
	};
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
