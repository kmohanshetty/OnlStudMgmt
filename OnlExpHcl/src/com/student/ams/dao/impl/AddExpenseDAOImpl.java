package com.student.ams.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.student.ams.dao.AddExpenseDAO;
import com.student.ams.dom.Project;
import com.student.ams.dom.User;
import com.student.ams.dom.UserProjects;
import com.student.ams.util.JdbcUtility;

public class AddExpenseDAOImpl implements AddExpenseDAO{

	@Override
	public UserProjects fetchAllUserProjects() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		UserProjects userProjects = new UserProjects();
		List<User> users = new ArrayList<User>();
		List<Project> projects = new ArrayList<Project>();
		
		con = JdbcUtility.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			if(rs != null){
				User user = null;
				Project project = null;
				while(rs.next()) {
					user = new User();
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setDob(rs.getDate(3));
					user.setUserType(rs.getString(4));
					users.add(user);
				}
				userProjects.setUsers(users);
				
				ps = con.prepareStatement("select * from project");
				rs = ps.executeQuery();
				if(rs != null){
					project = new Project();
					
					while(rs.next()) {
						project = new Project();
						project.setProjectId(rs.getInt(1));
						project.setProjectName(rs.getString(2));
						project.setStartDate(sdf.format(rs.getDate(3)));
						projects.add(project);
					}
					userProjects.setProjects(projects);
				}
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
		
		return userProjects;
	}

	@Override
	public boolean saveExpense(String formUser, String formProject, String formExpense) {
		StringBuilder sql = new StringBuilder();
		int maxColValue = 0;
		Connection con = null;
		ResultSet rs =null;
		PreparedStatement ps = null;
		con = JdbcUtility.getConnection();
		
		try {
			ps = con.prepareStatement("select max(eid) from expense");
			rs = ps.executeQuery();
			
			if(rs != null){
				while(rs.next()) {
					maxColValue = rs.getInt(1);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		sql.append("insert into expense(eid,uid,pid,expense,expenseDate) values(?,?,?,?,now())");
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, maxColValue + 1);
			ps.setInt(2, Integer.parseInt(formUser));
			ps.setInt(3, Integer.parseInt(formProject));
			ps.setDouble(4, Double.parseDouble(formExpense));
			int res = ps.executeUpdate();
			
			if(res > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	
}
