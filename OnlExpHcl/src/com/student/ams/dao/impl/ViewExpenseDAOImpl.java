package com.student.ams.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.ams.dao.ViewExpenseDAO;
import com.student.ams.dom.Expense;
import com.student.ams.util.JdbcUtility;

public class ViewExpenseDAOImpl implements ViewExpenseDAO {

	@Override
	public List<Expense> fetchAllExpense() {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct p.projectid,p.projectname,u.userId,u.userName,e.expense from project p inner join expense e on p.projectid=e.pid inner join user u on u.userId = e.uid");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		Expense expense = null;
		List<Expense> expenseList = new ArrayList<Expense>();
		
		con = JdbcUtility.getConnection();
		
		try {
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					expense = new Expense();
					expense.setProjectId(rs.getInt(1));
					expense.setProjectName(rs.getString(2));
					expense.setUserId(rs.getInt(3));
					expense.setUserName(rs.getString(4));
					expense.setExpense(rs.getDouble(5));
					expenseList.add(expense);
				}
			}
			
		}catch (SQLException e) {
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
		
		return expenseList;
	}
	
}
