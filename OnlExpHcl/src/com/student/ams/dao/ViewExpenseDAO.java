package com.student.ams.dao;

import java.util.List;

import com.student.ams.dom.Expense;

public interface ViewExpenseDAO {
	public List<Expense> fetchAllExpense();
}
