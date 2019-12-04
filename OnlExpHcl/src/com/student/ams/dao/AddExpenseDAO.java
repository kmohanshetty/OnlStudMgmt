package com.student.ams.dao;

import com.student.ams.dom.UserProjects;

public interface AddExpenseDAO {
	public UserProjects fetchAllUserProjects();
	
	public boolean saveExpense(String formUser, String formProject, String formExpense);
}
