<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	String s = "ovo je jedna recenica od nekoliko rijeci, sa dodatnim rijecima";
	pageContext.setAttribute("s", s);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
	<c:forTokens var="word" items="${s}" delims=" ,">
		<li><c:out value="${word}"></c:out>
	</c:forTokens>
</ul>
</body>
</html>