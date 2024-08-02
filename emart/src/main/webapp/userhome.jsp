<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
Connection 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emart","root","root");
Statement s=con.createStatement();
ResultSet rs =s.executeQuery("select * from product");%>
<h1>WELCOME TO USER PAGE</h1>
<table  border='5' style='margin:auto;' >
<tr>
<th>ID</th>
<th>name</th>
<th>price</th>
<th>brand</th>

</tr>
<% while(rs.next()){%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getDouble(3) %></td>
<td><%=rs.getString(4) %></td>

   
</tr>
<%} %>
</table>
<% con.close();
s.close();
rs.close();%>

<a href="insta"><button>follow us on instagram</button></a>
<script type="text/javascript">
	let logEle= document.getElementById("id");
	setTimeout(()=>{logEle.textContent="none"},2000);
</script>
</body>
</html>