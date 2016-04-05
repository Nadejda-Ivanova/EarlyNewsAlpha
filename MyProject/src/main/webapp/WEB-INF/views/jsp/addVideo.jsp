<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add video</title>
</head>
<body>
<spring:form method="post" commandName="video">
<p>Paste you tube link in the here"</p>
<spring:input type="text" path="name"/>
<br>
<input type="submit"/>
</spring:form>


</body>
</html>