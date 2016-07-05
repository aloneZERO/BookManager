package com.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.leo.model.User;

/**
 * 用户Dao类
 * @author leo
 *
 */
public class UserDao {
	/**
	 * 用户登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con, User user)throws Exception {
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		
		ResultSet rs = pstmt.executeQuery(); //执行查询
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
	
	/**
	 * 用户注册，添加管理员用户
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int register(Connection con, User user)throws Exception {
		String sql = "insert into t_user values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		return pstmt.executeUpdate();
	}
}
