<%@page import="com.student.ams.dom.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.student.ams.dom.UserProjects, java.util.List,com.student.ams.dom.User,com.student.ams.dom.HyperlinkBean" %>

<%
UserProjects userProjects = (UserProjects) request.getAttribute("UserProjects");
List<User> users = userProjects.getUsers();
List<Project> projects = userProjects.getProjects();

User user =  (User) session.getAttribute("userObj");

String userType = "";
System.out.println("user -> jsp - >"+user);
if(user != null){
	userType = user.getUserType();
}
List hyperlinkLst = (List) session.getAttribute("hyperlinkLst");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add expense</title>
		<script type="text/javascript">
		function beforeSubmit(){
			document.getElementById('action').value = "addExpense";
			return true;
		}
		</script>
	</head>
	<body>
		<table align="center" border="0" width="100%">
			<tbody>
				<tr>
					<td><h3>Expense Management</h3></td>
					<td><a href="http://<%=request.getServerName()%>:<%=request.getServerPort()%>/<%=request.getContextPath()%>/logout">Logout</a></td>
				</tr>
				<%if(hyperlinkLst != null && hyperlinkLst.size() > 0 ){ %>
				<%for(int i=0;i<hyperlinkLst.size();i++){ %>
				<%	HyperlinkBean hyperlinkBean = (HyperlinkBean) hyperlinkLst.get(i); %>
					<tr>
						<td><a href="<%=hyperlinkBean.getUrl() %>"><%=hyperlinkBean.getName() %></a></td>
					</tr>
				<%} %>
				<%} %>
			</tbody>
		</table>
		<h2>Add expense</h2>
		<form method="post" action="<%=request.getContextPath()%>/addExpense">
			<table>
				<tbody>
					<tr>
						<td>User:</td>
						<td>
							<select id="user" name="user">
								<option value="select">Select</option>
								<%for(int i = 0;i < users.size(); i++){ %>
								<option value="<%=users.get(i).getUserId()%>">
									<%=users.get(i).getUserName() %>
								</option>
								<%} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Project:</td>
						<td>
							<select id="project" name="project">
									<option value="select">Select</option>
								<%for(int i = 0;i < projects.size(); i++){ %>
									<option value="<%=projects.get(i).getProjectId()%>">
										<%=projects.get(i).getProjectName() %>
									</option>
								<%} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Expense:</td>
						<td><input type="text" id="expense" name="expense"></td>
					</tr>
					<tr>
						<td>Save Expense:</td>
						<td>
							<input type="submit" value="Submit" onclick="return beforeSubmit()">
							<input type="hidden" name="action" id="action" value="">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>