package com.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.leo.model.Book;
import com.leo.util.StringUtil;

/**
 * 图书Dao类
 * @author leo
 *
 */
public class BookDao {
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception {
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书查重判断
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public boolean isRepeat(Connection con, Book book)throws Exception {
		String sql = "select * from t_book where bookName=? and author=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 图书信息列表
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception {
		StringBuilder sb = new StringBuilder("select * from t_book b,t_bookType bt "
				+ "where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书信息更新
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book)throws Exception {
		String sql = "update t_book set bookName=?,author=?,sex=?,price=?,"
				+ "bookTypeId=?,bookDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
}
