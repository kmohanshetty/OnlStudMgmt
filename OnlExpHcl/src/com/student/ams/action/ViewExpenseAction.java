package com.student.ams.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.ams.dom.User;
import com.student.ams.service.impl.ViewExpenseImpl;

public class ViewExpenseAction extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		User user = (User)request.getSession().getAttribute("userObj");
		System.out.println("user: "+user);
		if(user == null){
			request.getSession().invalidate();
			doFoward(request,response,"/WEB-INF/jsp/login/login.jsp");
		}
		
		com.student.ams.service.ViewExpense viewExpenseService = new ViewExpenseImpl();
		
		request.setAttribute("expenseList", viewExpenseService.fetchAllExpense());
		doFoward(request,response,"/WEB-INF/jsp/login/viewExpense.jsp");
	}
	
	public void doFoward(HttpServletRequest request,HttpServletResponse response,String url)throws ServletException,IOException{
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
