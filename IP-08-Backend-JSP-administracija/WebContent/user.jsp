<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h2>User interface</h2>
<h3>Nova vijest</h3>
	<form id="naviVijest" method="post" action="./kreirajVijest">
		Naslov vijesti: <br/>
		<input name="title" id="title" type="text" /><br/>
		Tekst vijesti: <br/>
		<input name="content" id="content" type="text" /><br/><br/>
		<input type="submit" value="Kreiraj vijest" />
	</form>
<h3>Lista vijesti</h3>
<form id="prikazKorisnika" method="post" action="./obrisiVijest">
	<table border="1" width="100%">
		<tr>
			<td>Korisnicko ime</td>
			<td>Lozinka</td>
			<td>Datum</td>
		</tr>
		<c:forEach items="${messageDB.messages}" var="message" >
			<tr>
				<td>${message.title}</td>
				<td>${message.content}</td>
				<td>${message.date}</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>