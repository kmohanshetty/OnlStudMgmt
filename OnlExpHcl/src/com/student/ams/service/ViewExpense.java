package com.student.ams.service;

import java.util.List;

import com.student.ams.dom.Expense;

public interface ViewExpense {
	public List<Expense> fetchAllExpense();
}
