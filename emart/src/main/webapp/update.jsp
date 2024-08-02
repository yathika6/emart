<%@page import="com.mysql.cj.exceptions.RSAException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ResultSet rs= (ResultSet) request.getAttribute("rs");
if(rs.next());
{
%>

<h1 align="center">UPDATE HERE</h1>
<form  class="form" action="update" method="post">
<input type="text" name="id" value="<%= rs.getInt(1) %>" placeholder="enter id" readonly="readonly" >
<input type="text" name="name" value="<%= rs.getString(2) %>" placeholder="enter product name">
<input type="text" name="price" value="<%= rs.getDouble(3) %>" placeholder="enter price">
<input type="text" name="brand" value="<%= rs.getString(4)%>" placeholder="enter brand">
<button type="submit">update</button>
</form>
<%}  %>

</body>
</html>