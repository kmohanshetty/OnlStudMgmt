<%@page import="com.student.ams.dom.Expense, java.util.List,com.student.ams.dom.User,com.student.ams.dom.HyperlinkBean" %>
<%
List<Expense> expenseList = (List) request.getAttribute("expenseList");
User user =  (User) session.getAttribute("userObj");

String userType = "";
System.out.println("user -> jsp - >"+user);
if(user != null){
	userType = user.getUserType();
}
List hyperlinkLst = (List) session.getAttribute("hyperlinkLst");

%>
<html>
<head>
	<title>View project expense</title>
</head>
<body>
	<h2 align="center">View project expense</h2>
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
	<table align="center" border="1">
		<tbody>
		<tr>
			<td>Project Id</td>
			<td>Project Name</td>
			<td>User Id</td>
			<td>User Name</td>
			<td>Expense</td>
		</tr>
		<%for(int i = 0;i<expenseList.size();i++){ %>
			<tr>
				<td><%=expenseList.get(i).getProjectId()%></td>
				<td><%=expenseList.get(i).getProjectName()%></td>
				<td><%=expenseList.get(i).getUserId()%></td>
				<td><%=expenseList.get(i).getUserName()%></td>
				<td><%=expenseList.get(i).getExpense()%></td>
			</tr>
		<% } %>	
		</tbody>
	</table>
</body>
</html>