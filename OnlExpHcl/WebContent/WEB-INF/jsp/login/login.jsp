<%
String errorMsg = (String) request.getAttribute("errorMsg");
if(errorMsg == null){
	errorMsg = "";
}
%>

<html>
	<head>
		<title>Login Page</title>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/login" method="POST">
		<table align="center" border="1">
			<tbody>
				<tr><td>Name:</td><td><input type="text" name="uname" id="uname"/></td></tr>
				<tr><td>Password:</td><td><input type="password" name="upwd" id="upwd"/></td></tr>
				<tr><td>Click here:</td><td><input type="submit" value="Submit"/></td></tr>
				<tr><td colspan="2"><font color="red"><%=errorMsg %></font></td></tr>
			</tbody>
		</table>	
		</form>
	</body>
</html>