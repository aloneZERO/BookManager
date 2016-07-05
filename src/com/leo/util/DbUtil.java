package com.leo.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author leo
 *
 */
public class DbUtil {
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_book_leo" //数据库地址
			+ "?useUnicode=true&characterEncoding=utf-8&useSSL=false" //设置SSL连接
			+"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//设置时区 
	private static String dbUsername = "root"; //用户名
	private static String dbPassword = ""; //用户密码
	private static String jdbcName = "com.mysql.cj.jdbc.Driver"; //数据库驱动名称
	
	/**
	 * 获取数据库连接
	 * @return con
	 * @throws Exception
	 */
	public Connection getCon()throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception {
		if(con != null) {
			con.close();
		}
	}
	
	/**
	 * 数据库连接测试
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
	}
}
