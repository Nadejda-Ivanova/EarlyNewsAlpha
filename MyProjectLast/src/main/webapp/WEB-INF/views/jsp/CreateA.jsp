<%@page import="com.example.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add new Article</title>
</head>
<body>

<%if(request.getAttribute("message")!= null){%>
	<h4><a href="./Upload">${message}</a></h4>
	<%}%>
	

	

	<spring:form method="post" commandName="newArticle">
	<label>Title</label>
	<spring:input type="text" path="title"/>
	<br/>
	<label>Text</label>
	<spring:textarea rows="5" cols="60" path="text"/>
	<br/><br/>
	Select Category<br>
	
	<spring:radiobuttons path="catId" items="${catList}" itemValue="id" itemName="name" />
	
<br>
	
	<input type="submit"/>

</spring:form>
<br><br>
<a href=./mainPage>Back to main page</a>


</body>
</html>