package com.student.ams.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.ams.dom.HyperlinkBean;
import com.student.ams.dom.User;

public class ProcessAction extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		User user = (User) request.getSession().getAttribute("userObj");
		List hyperlinkLst = new ArrayList();
		
		String serverUrl = "";
		
		serverUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
		
		if(user != null && user.getUserType().equals("U")){
			HyperlinkBean hyperlinkBean = null;
			
			hyperlinkBean = new HyperlinkBean();
			hyperlinkBean.setName("View my project expense.");
			hyperlinkBean.setUrl(serverUrl+"viewExpense");
			hyperlinkLst.add(hyperlinkBean);
			
			hyperlinkBean = new HyperlinkBean();
			hyperlinkBean.setName("Search projects");
			hyperlinkBean.setUrl(serverUrl+"searchProject");
			hyperlinkLst.add(hyperlinkBean);
			
			hyperlinkBean = new HyperlinkBean();
			hyperlinkBean.setName("Add expense");
			hyperlinkBean.setUrl(serverUrl+"addExpense");
			hyperlinkLst.add(hyperlinkBean);
			
		}else if(user != null && user.getUserType().equals("M")){
			HyperlinkBean hyperlinkBean = null;
			
			hyperlinkBean = new HyperlinkBean();
			hyperlinkBean.setName("Review projects");
			hyperlinkBean.setUrl(serverUrl+"viewExpense");
			hyperlinkLst.add(hyperlinkBean);
			
			hyperlinkBean = new HyperlinkBean();
			hyperlinkBean.setName("Add projects");
			hyperlinkBean.setUrl(serverUrl+"searchProject");
			hyperlinkLst.add(hyperlinkBean);
			
			hyperlinkBean = new HyperlinkBean();
			hyperlinkBean.setName("Approve users");
			hyperlinkBean.setUrl(serverUrl+"addExpense");
			hyperlinkLst.add(hyperlinkBean);
		}
		
		request.getSession().setAttribute("hyperlinkLst", hyperlinkLst);
		doFoward(request,response,"/WEB-INF/jsp/login/home.jsp");
	}
	
	public void doFoward(HttpServletRequest request,HttpServletResponse response,String url)throws ServletException,IOException{
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
