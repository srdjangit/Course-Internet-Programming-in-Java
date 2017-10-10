<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set value="<%= new java.util.Date()%>" var="d"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fmt:formatDate value="${d}" pattern="dd.MM.yyyy HH:mm:ss"/>
<fmt:formatNumber value="100" type="number" minIntegerDigits="4" minFractionDigits="1" var="num"></fmt:formatNumber>
<fmt:setTimeZone value="GMT-8"></fmt:setTimeZone>
<br>
<fmt:formatDate value="${d}" pattern="dd.MM.yyyy HH:mm:ss"/>
<br>
<c:out value="${num}"></c:out>
</body>
</html> 