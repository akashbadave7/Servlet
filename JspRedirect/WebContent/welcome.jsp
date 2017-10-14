<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jsp Programs</title>
</head>
<body>
<%-- <% response.sendRedirect("http://www.google.com");%> --%>
<%
String name = request.getParameter("name");
String driver = config.getInitParameter("driver");
out.println("Welcome "+name);

out.println("<br>Driver name : "+driver);
session.setAttribute("name", name);

out.print("<br>"+session.getAttribute("name"));
out.print("<br>"+session.getId());
%>

<%@ page import ="java.util.*" %>
<%-- <%@ page contentType="application/msword" %>   --%>
<br>Today date is : <%= new Date()%>



</body>
</html>