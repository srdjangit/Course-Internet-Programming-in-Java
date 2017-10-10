<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <body>
  <h1>Get Value from bean</h1>
    <jsp:useBean id="emp" class="primjer03.Employees" scope="page">
        <jsp:setProperty name="emp" property="firstName" value='<%= request.getParameter("ime") %>'/>
        <jsp:setProperty name="emp" property="lastName" value='<%= request.getParameter("prezime") %>'/>
        <jsp:setProperty name="emp" property="address" value='<%= request.getParameter("adresa") %>'/>
    </jsp:useBean>

     <table>
      <tr>
       <td>First Name</td>
       <td> : </td>
       <td> <jsp:getProperty name="emp" property="firstName"/> </td>
      </tr>
      <tr>
       <td>Last Name</td>
       <td> : </td>
       <td> <jsp:getProperty name="emp" property="lastName"/> </td>
      </tr>
      <tr>
       <td>Address</td>
       <td> : </td>
       <td> <jsp:getProperty name="emp" property="address"/> </td>
      </tr>
     </table>

  </body>
</html>

