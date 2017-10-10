<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1>Message board</h1>
	<hr/>
	<!-- 
		HTML forma za logovanje, metod prenosa podataka je POST, 
		a podaci idu na adresu funkcije unutar servleta koja se zove /login
	-->
	<form id="loginForm" method="post" action="./login">
		Username: <br/>
		<input name="username" id="username" type="text" /><br/>
		Password: <br/>
		<input name="password" id="password" type="text" /><br/><br/>
		<input type="submit" value="Login" />
	</form>
	<!-- 
		Forma za testiranje POST i GET zahtjeva
	 -->
	<hr/>
	<h2>Testiranje POST i GET zahtjeva</h2>
	<form method="post" action="./CounterServlet">
		Send POST request: <input type="submit" value="SUBMIT POST" />
	</form>
	<br/>
	<form method="get" action="./CounterServlet">
		Send GET request: <input type="submit" value="SUBMIT GET" />
	</form>
	<hr/>
</body>
</html>