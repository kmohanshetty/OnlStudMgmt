<%@page import="com.student.ams.dom.User,java.util.List" %>
<%
User user =  (User) session.getAttribute("userObj");
if(user == null){
	response.sendRedirect("login");
} else {
	response.sendRedirect("processAction");
}

%>