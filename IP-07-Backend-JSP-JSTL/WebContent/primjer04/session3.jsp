<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%if (session.getAttribute("name")==null) 
	response.sendRedirect("session1.jsp");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Zdravo, <%= session.getAttribute("name") %> !
<br>
Maksimalan period neaktivnosti: <%=session.getMaxInactiveInterval() %> sekundi, odnosno 
<%=session.getMaxInactiveInterval()/60 %> minuta
</body>
</html>