<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${not empty error}">${error}
</c:if>

<spring:form method="post" commandName="unsubscribe">
<p>provide your e-mail below to unsubscribe from our newsletter</p>
<spring:input type="text" path="email"/>
<br>
<input type="submit"/>
</spring:form>


</body>
</html>