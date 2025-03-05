<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("Login.jsp");
    }
    String username = (String) session1.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>

</head>
<body>
	<h1>WELCOME <%= username %>!</h1>
	<p>we are delighted to have u on our platform</p>
	<p><a href="LogoutServlet">LOGOUT</a></p>
</body>
</html>