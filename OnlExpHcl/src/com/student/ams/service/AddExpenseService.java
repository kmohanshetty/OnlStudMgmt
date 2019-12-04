package com.student.ams.service;

import com.student.ams.dom.UserProjects;

public interface AddExpenseService {
	public UserProjects fetchAllUserProjects();
	public boolean saveExpense(String formUser, String formProject, String formExpense);
}
