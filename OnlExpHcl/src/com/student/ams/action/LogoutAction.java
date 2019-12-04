package com.student.ams.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.ams.dom.User;

public class LogoutAction extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		User user = (User)request.getSession().getAttribute("userObj");
		if(user != null){
			request.getSession().invalidate();
		}
		doFoward(request,response,"/WEB-INF/jsp/login/login.jsp");
	}
	
	public void doFoward(HttpServletRequest request,HttpServletResponse response,String url)throws ServletException,IOException{
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
