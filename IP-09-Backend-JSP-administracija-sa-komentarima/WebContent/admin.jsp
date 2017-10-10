<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h2>Administracija</h2>
	<p>Kroz administraciju moguce je pregledati postojece korisnike i dodati nove.</p>
	<hr/>
	<h3>Lista postojecih korisnika</h3>
	<form id="prikazKorisnika" method="post" action="./obrisiKorisnika">
	<table border="1" width="100%">
		<tr>
			<td>Korisnicko ime</td>
			<td>Lozinka</td>
			<td>Akcije</td>
		</tr>
		<c:forEach items="${userDB.users}" var="user" >
			<tr>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td><input type="submit" value="Obrisi korisnika" /></td>
			</tr>
		</c:forEach>
	</table>
	</form>
	<hr/>
	<h3>Novi korisnicki nalog</h3>
	<form id="noviKorisnickiNalog" method="post" action="./kreirajKorisnika">
		Username: <br/>
		<input name="username" id="username" type="text" /><br/>
		Password: <br/>
		<input name="password" id="password" type="text" /><br/><br/>
		<input type="submit" value="Kreiraj korisnika" />
	</form>
</body>
</html>