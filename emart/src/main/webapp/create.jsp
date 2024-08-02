<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>CREATE A NEW PRODUCT</h1>
<form method="post" action="create_product">
<input type="text"  name="id" placeholder="enter id">
<input type="text" name="name" placeholder="enter product name">
<input type="text" name="price" placeholder="enter price">
<input type="text" name="brand" placeholder="enter brand">  
<a><button type="submit"> CREATE</button></a>
</form>

</body>
</html>