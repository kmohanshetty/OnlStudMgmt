package com.student.ams.dao;

import com.student.ams.dom.User;

public interface LoginDAO {
	public User validateUser(String userName,String password);
}
