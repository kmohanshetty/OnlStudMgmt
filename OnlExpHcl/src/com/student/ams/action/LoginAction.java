/**
 * 
 */
package com.student.ams.action;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.ams.service.LoginService;
import com.student.ams.service.impl.LoginServiceImpl;
import com.student.ams.util.JdbcUtility;

/**
 * @author Mr.Screwed-Up
 *
 */
public class LoginAction extends HttpServlet{
	public void init(){
		System.out.println("init called");
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String url = "/WEB-INF/jsp/login/login.jsp";
//		URL urlq = JdbcUtility.class.getClassLoader().getResource("db.conf");
		int res = -1;
		LoginService loginService = new LoginServiceImpl();
		res = loginService.validateUser(request);
		if(res == 1){
			url = "/processAction";//success page
		}else if(res == 0){
			url = "/WEB-INF/jsp/login/login.jsp";//failure
			request.setAttribute("errorMsg", "User name / Password entered is Wrong.");
		}else if(res == -1){
			url = "/WEB-INF/jsp/login/login.jsp";//failure
		}
		doFoward(request,response,url);
	}
	
	public void doFoward(HttpServletRequest request,HttpServletResponse response,String url)throws ServletException,IOException{
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	public void destroy(){
		System.out.println("destroy called");
	}
}
