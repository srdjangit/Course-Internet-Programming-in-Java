<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="calculator" class="primjer02.Calculator" scope="session"/>
<jsp:setProperty name="calculator" property="number1" value='<%= request.getParameter("broj1").toString() %>' />
<jsp:setProperty name="calculator" property="number2" value='<%= request.getParameter("broj2").toString() %>' />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="calculator3.jsp">Sljedeca stranica</a>
</body>
</html>