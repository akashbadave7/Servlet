<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Scripting tag -->
<% String name = request.getParameter("uname");%>
<% out.print("Welcome "+name);%>
	<!-- Expression tag -->
	<br><%="Welcome to jsp" %>
	<br><%out.print(2*8); %>
	
	<!-- Declaration tag -->
	<%! int data = 50; %>
	<br>
	<% out.print("Value of data "+data); %>
	
	<%! int cube(int n)
		{
			return n*n*n;
		}
	%>
		<br>
		<%= "Cube of 3 is "+cube(3) %>
	
		<br><% out.print("Todays date is : "+Calendar.getInstance().getTime()); %>
</body>
</html>