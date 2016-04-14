<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Category</title>
</head>
<body>

<spring:form method="post" commandName="newCategory">
	<label>Category name</label>
	<spring:input type="text" path="name"/>
	<br/>
	<label>Category sorting</label>
	<spring:input type="number" path="sortOrder"/>
	<br/>
	<label>Top category </label>
	<spring:checkbox path="top"/>
	<br/>
	<label>Main category</label>
	<spring:checkbox path="main"/>
	
	<input type="submit"/>

</spring:form>
<br><br>
<a href=./mainPage>Back to main page</a>
</body>
</html>