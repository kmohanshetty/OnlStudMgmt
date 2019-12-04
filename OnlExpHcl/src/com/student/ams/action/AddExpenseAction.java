package com.student.ams.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.ams.dom.User;
import com.student.ams.service.AddExpenseService;
import com.student.ams.service.impl.AddExpenseServiceImpl;

public class AddExpenseAction  extends HttpServlet{
	public void init(){
		System.out.println("add expense init called");
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String url = "/WEB-INF/jsp/login/addExpense.jsp";
		String action = request.getParameter("action");
		AddExpenseService addExpenseService = new AddExpenseServiceImpl();
		
		User user = (User)request.getSession().getAttribute("userObj");
		System.out.println("user: "+user);
		if(user == null){
			request.getSession().invalidate();
			doFoward(request,response,"/WEB-INF/jsp/login/login.jsp");
		}
		
		if(action != null && action.equals("addExpense")) {
			//here add logic to save the expenses
			String formUser = request.getParameter("user");
			String formProject = request.getParameter("project");
			String formExpense = request.getParameter("expense");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("formUser: "+formUser+" formProject:"+formProject+" formExpense:"+formExpense);
			addExpenseService.saveExpense(formUser, formProject, formExpense);
		}
		//by default load users and project list
		request.setAttribute("UserProjects", addExpenseService.fetchAllUserProjects());
		
		doFoward(request,response,url);
	}
	
	public void doFoward(HttpServletRequest request,HttpServletResponse response,String url)throws ServletException,IOException{
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	public void destroy(){
		System.out.println("add expense destroy called");
	}
}
