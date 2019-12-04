package com.student.ams.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.student.ams.dao.LoginDAO;
import com.student.ams.dao.impl.LoginDAOImpl;
import com.student.ams.dom.User;
import com.student.ams.service.LoginService;

public class LoginServiceImpl implements LoginService {

	public int validateUser(HttpServletRequest request) {
		String userName = "";
		String password = "";
		int res = 0;
		LoginDAO loginDao = null;
		User user = null;
		
		userName = request.getParameter("uname");
		password = request.getParameter("upwd");
		
		if(userName != null && !userName.equals("") && password != null && !password.equals("")){
			loginDao = new LoginDAOImpl();
			user = loginDao.validateUser(userName, password);
			if(user != null){
				res = 1;//1 means success.
				request.getSession().setAttribute("userObj", user);
			}else if(user == null){
				res = 0; //0 means failure.
			}
		}else if(userName == null && password == null){
			res = -1; //0 means failure.
		}else{
			res = 0; //0 means failure.
		}
		
		return res;
	}

}
