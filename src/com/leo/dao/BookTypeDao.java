package com.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.leo.model.BookType;
import com.leo.util.StringUtil;

/**
 * 图书类别Dao类
 * @author leo
 *
 */
public class BookTypeDao {
	
	/**
	 * 添加图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, BookType bookType)throws Exception {
		String sql = "insert into t_booktype values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书类别查重判断
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public boolean isRepeat(Connection con, BookType bookType)throws Exception {
		String sql = "select * from t_booktype where bookTypeName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 查询图书类别集合
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, BookType bookType)throws Exception {
		StringBuilder sb = new StringBuilder("select * from t_booktype");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'"); //采用模糊查询
		}
		
		//先写and后替换成where是为了适应多条件查询
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书类别删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,int id)throws Exception {
		String sql = "delete from t_bookType where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书类别更新
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con ,BookType bookType)throws Exception {
		String sql = "update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
	
}
