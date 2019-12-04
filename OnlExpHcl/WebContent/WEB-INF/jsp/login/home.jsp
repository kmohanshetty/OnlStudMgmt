<%@page import="com.student.ams.dom.User,java.util.List,com.student.ams.dom.HyperlinkBean" %>
<%
User user =  (User) session.getAttribute("userObj");

String userType = "";
if(user != null){
	userType = user.getUserType();
}
List hyperlinkLst = (List) session.getAttribute("hyperlinkLst");

%>

<html>
	<head>
		<title>Home Page</title>
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
	</body>
</html>