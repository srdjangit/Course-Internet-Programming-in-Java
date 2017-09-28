<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:if test="${pageContext.request.method=='POST'}">Unijeli ste:
    
    <c:choose>
      <c:when test="${param.enter=='1'}">Jedan
      <br />
      </c:when>

      <c:when test="${param.enter=='2'}">Dva
      <br />
      </c:when>

      <c:when test="${param.enter=='3'}">Tri
      <br />
      </c:when>

      <c:when test="${param.enter=='4'}">Cetiri
      <br />
      </c:when>

      <c:when test="${param.enter=='5'}">Pet
      <br />
      </c:when>

      <c:otherwise>
        <c:out value="${param.enter}" />

        <br />
      </c:otherwise>
    </c:choose>
    </c:if>

    <form method="post" action="">Unesite broj izmedju 1 i 5:
    <input type="text" name="enter" />
    <input type="submit" value="Prihvati" />

    <br />
    </form>
</body>
</html>