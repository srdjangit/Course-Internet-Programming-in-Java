<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource driver="sun.jdbc.odbc.JdbcOdbcDriver"
	url="jdbc:odbc:student" user="" password="" />
<sql:query var="student"> SELECT * FROM student
</sql:query>
<ul>
	<c:forEach var="row" items="${student.rows}">
		<li><c:out value="${row.ime}" /> <c:out
			value="${row.prezime}" /> <c:out
			value="${row.email}" /></li>
	</c:forEach>
</ul>
</body>
</html>