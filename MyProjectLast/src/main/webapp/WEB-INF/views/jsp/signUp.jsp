<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new user</title>
</head>
<body>
<%if(request.getAttribute("errorMessage")!= null){%>
	<h4>${errorMessage}</h4>
	<%}%>


<spring:form method="post" commandName="user">
	<label>user name</label>
	<spring:input type="text" path="name"/>
	<br/>
	<label>password</label>
	<spring:input type="password" path="password"/>
	<br/>
	<label>email</label>
	<spring:input type="email" path="email"/>
	<br/>
	<input type="submit"/>

</spring:form>
<br><br>
<a href=./mainPage>Back to main page</a>
</body>
</html>