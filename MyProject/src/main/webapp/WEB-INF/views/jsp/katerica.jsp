<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getAttribute("message")!= null){%>
	<h4>${message}</h4>
	<%}%>

	<spring:form method="post" commandName="katerica">
	<label>Katerica name</label>
	<spring:input type="text" path="name"/>
	<br/>
	<label>Katerica length</label>
	<spring:input type="number" path="length"/>
	
	<input type="submit"/>

</spring:form>



</body>
</html>