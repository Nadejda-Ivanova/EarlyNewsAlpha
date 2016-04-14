<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add video</title>
</head>
<body>
 <c:if test="${not empty error}">${error}</c:if>

<spring:form method="post" commandName="video">
<p>Paste Youtube link in the here"</p>
<spring:input type="text" path="name"/>
<br>
<input type="submit"/>
</spring:form>

<a href="/MyProject/uploadcontroller">do not add video, go to pictures upload</a>
</body>
</html>