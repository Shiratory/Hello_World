package com.yedam.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeviceJdbc {
	
	
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
	
	// 추가문
	public boolean insert(Device device) {
		Connection conn = getConnect();
		String sql = "insert into tbl_device (dev_code, dev_name, unpack, stock)\r\n"
				   + "values(?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, device.getDeviceCode());
			stmt.setString(2, device.getDeviceName());
			stmt.setInt(3, device.getUnpack());
			stmt.setString(4, device.getStock());
			
		
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return false;
	}
	
	
	// 수정문
	public boolean update(Device device) {
		Connection conn = getConnect();
		String sql = "update tbl_device "
				   + "set dev_name = nvl(?, dev_name) "
				   + "   ,unpack = ? "
				   + "   ,stock = nvl(?, stock) "
				   + "where dev_code = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, device.getDeviceName());
			stmt.setInt(2, device.getUnpack());
			stmt.setString(3, device.getStock());
			stmt.setString(4, device.getDeviceCode());
			
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 삭제문
	public boolean delete(String DeviceCode) {
		Connection conn = getConnect();
		String sql = "delete from tbl_device where dev_code = '"+ DeviceCode+ "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			if(r > 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 전체목록
	public List<Device> list(String DeviceName){
		List<Device> list = new ArrayList<Device>();
		Connection conn = getConnect();
		String sql = "select * from tbl_device ";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				Device device = new Device();
				device.setDeviceCode(rs.getString("dev_code"));
				device.setDeviceName(rs.getString("dev_name"));
				device.setUnpack(rs.getInt("unpack"));
				device.setStock(rs.getString("stock"));
				list.add(device);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	// 기기명으로 검색
	public List<Device> select(String dcode) {
		List<Device> list = new ArrayList<Device>();
		Connection conn = getConnect();
		String sql = "select * from tbl_device "
				   + "where dev_name like ?";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dcode + "%");
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Device device = new Device();
				device.setDeviceCode(rs.getString("dev_code"));
				device.setDeviceName(rs.getString("dev_name"));
				device.setUnpack(rs.getInt("unpack"));
				device.setStock(rs.getString("stock"));
				list.add(device);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
