package com.student.ams.service.impl;

import com.student.ams.dao.AddExpenseDAO;
import com.student.ams.dao.impl.AddExpenseDAOImpl;
import com.student.ams.dom.UserProjects;
import com.student.ams.service.AddExpenseService;

public class AddExpenseServiceImpl implements AddExpenseService {

	@Override
	public UserProjects fetchAllUserProjects() {
		AddExpenseDAO dao = new AddExpenseDAOImpl();

		return dao.fetchAllUserProjects();
	}

	@Override
	public boolean saveExpense(String formUser, String formProject, String formExpense) {
		AddExpenseDAO dao = new AddExpenseDAOImpl();
		
		return dao.saveExpense(formUser, formProject, formExpense);
	}

	

}
