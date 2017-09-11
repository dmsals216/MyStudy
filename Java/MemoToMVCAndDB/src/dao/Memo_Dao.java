package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Memo;

public class Memo_Dao {
	
	public static String URL = "jdbc:mysql://localhost:3306/memo";
	public static String ID = "root";
	public static String PW = "1234";
	
	public Memo_Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void insertMemoDao(Memo memo) {
		String sql = "insert into memo (name, content, datetime) values (?, ?, now())";
		try(Connection conn = DriverManager.getConnection(URL, ID, PW)) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, memo.getAuthor());
			stmt.setString(2, memo.getContent());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMemoDao(Memo memoUpdate) {
		String sql = "update memo set name = ?, content = ? where no = ?";
		try(Connection conn = DriverManager.getConnection(URL, ID, PW)) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, memoUpdate.getAuthor());
			stmt.setString(2, memoUpdate.getContent());
			stmt.setInt(3, memoUpdate.getIndex());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMemoDao(String index) {
		String sql = "delete from memo where no = " + index;
		try(Connection conn = DriverManager.getConnection(URL, ID, PW)) {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Memo getOneMemoDao(String index) {
		String sql = "select * from memo where no = " + index;
		Memo memo = new Memo();
		try(Connection conn = DriverManager.getConnection(URL, ID, PW)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				memo.setIndex(rs.getInt("no"));
				memo.setAuthor(rs.getString("name"));
				memo.setContent(rs.getString("content"));
				memo.setDatetime(rs.getTimestamp("datetime"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memo;
	}
	
	public ArrayList<Memo> getMemoListDao() {
		String sql = "select * from memo";
		ArrayList<Memo> memoList = new ArrayList();
		Memo memo = new Memo();
		try(Connection conn = DriverManager.getConnection(URL, ID, PW)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				memo.setIndex(rs.getInt("no"));
				memo.setAuthor(rs.getString("name"));
				memo.setContent(rs.getString("content"));
				memo.setDatetime(rs.getTimestamp("datetime"));
				memoList.add(memo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memoList;
	}
}
