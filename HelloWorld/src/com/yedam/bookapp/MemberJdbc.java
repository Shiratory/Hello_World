package com.yedam.bookapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberJdbc {
	// Connection 생성.
		Connection getConnect() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userId = "scott";
			String userPw = "tiger";

			try {
				Connection conn = DriverManager.getConnection(url, userId, userPw);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		// 로그인
		// id, pw 조홰 후 결과가 있을시 로그인성공, 실패
	public User login(String id, String pw) {
		Connection conn = getConnect();
		String sql = "select * from tbl_member"
				   + " where user_id = ?" 
				   + " and password = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();	
			
			if(rs.next()) {
				User user = new User(rs.getString("user_id"), 
									 rs.getString("user_name"), 	
									 rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
		
	public List<Map<String, String>> memberList(){
//	 [{userId : "user01", password: "1111" userName: "홍길동"}]
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection conn = getConnect();// 디비 session
		String sql = "select * from tbl_member";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				// userId, password, userName 저장할 콜렉숀
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", rs.getString("user_id"));
				map.put("password", rs.getString("password"));
				map.put("userName", rs.getString("user_name"));
				list.add(map);
				map.get("userId");
				System.out.println(map.get("userId"));
		}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
