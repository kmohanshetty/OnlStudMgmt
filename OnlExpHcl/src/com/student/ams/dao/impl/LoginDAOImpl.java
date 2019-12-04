package com.student.ams.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.ams.dao.LoginDAO;
import com.student.ams.dom.User;
import com.student.ams.util.JdbcUtility;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public User validateUser(String userName, String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("select user.* from user where userName=? and password = ?");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		User user = null;
		int userId = 0;
		String usrName = null;
		String userType = null;
		Date dob = null;
		
		con = JdbcUtility.getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, userName);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				userId = rs.getInt("userId");
				user.setUserId(userId);
				usrName = rs.getString("userName");
				user.setUserName(usrName);
				userType = rs.getString("userType");
				user.setUserType(userType);
				dob = rs.getDate("dob");
				user.setDob(dob);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		return user;
	}

}
