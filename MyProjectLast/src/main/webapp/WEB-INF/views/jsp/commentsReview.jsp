<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Comments review page</h4>
	<c:choose>
		<c:when test="${not empty error}">
			<a href=./mainPage>There are no bad comments. Back to main page</a>
		</c:when>
		<c:otherwise>
			<spring:form method="post" commandName="review">
				<br />
				
				<br />
				
	Current comment<br>
				<spring:checkbox  path="toBeDeleted" value='${comment.id}'/> ${comment.text}
				<input name="id" type="hidden" value="${comment.id}"/>

				<br>

				<input type="submit" value='Delete selected' />

			</spring:form>
		</c:otherwise>
	</c:choose>
</body>
</html>