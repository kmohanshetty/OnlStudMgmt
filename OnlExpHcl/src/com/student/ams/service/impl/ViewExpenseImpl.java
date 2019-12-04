package com.student.ams.service.impl;

import java.util.List;

import com.student.ams.dao.ViewExpenseDAO;
import com.student.ams.dao.impl.ViewExpenseDAOImpl;
import com.student.ams.dom.Expense;
import com.student.ams.service.ViewExpense;

public class ViewExpenseImpl implements ViewExpense {
	
	@Override
	public List<Expense> fetchAllExpense() {
		ViewExpenseDAO viewExpense = new ViewExpenseDAOImpl();

		return viewExpense.fetchAllExpense();
	}

}
