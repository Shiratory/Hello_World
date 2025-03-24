package com.yedam.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserJdbc {
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		
		try {
			Connection conn;
			conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Userdata login(String id, String pw) {
		Connection conn = getConnect();
		String sql = "select * from tbl_member"
				   + " where user_id = ?"
				   + " and password = ?";
		try {
			PreparedStatement psmt;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				Userdata user = new Userdata(rs.getString("user_id"),
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
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection conn = getConnect();
		String sql = "select * from tbl_member";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", rs.getString("user_id"));
				map.put("password", rs.getString("password"));
				map.put("userName", rs.getString("user_name"));
				list.add(map);
				map.get("userId");
				System.out.println(map.get("userId"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
			return list;
	}
}
