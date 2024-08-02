<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products page </title>
<style type="text/css">
body{
font-size: 20px;
}
.all-prod{
margin-left: 470px;
}

</style>
</head>
<body>
<h1 class="all-prod">ALL PRODUCTS </h1>
<% ResultSet rs =(ResultSet) request.getAttribute("rs") ;%>

<a href="create_product_page"><button>create product</button></a>
<table  border='5' style='margin:auto;' >
<tr>
<th>ID</th>
<th>name</th>
<th>price</th>
<th>brand</th>
<th colspan="2">action</th>
</tr>
<% while(rs.next()){%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getDouble(3) %></td>
<td><%=rs.getString(4) %></td>
<td><a href="update_page?id=<%=rs.getInt(1)%>&"><button>update</button></a></td>
<td><a href="delete?id=<%=rs.getInt(1)%>"><button>delete</button> </a></td>
   
</tr>
<%} %>
</table>

</body>
</html>