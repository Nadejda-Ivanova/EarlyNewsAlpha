<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Picture upload</title>
</head>
<body>
<c:if test="${not empty success}">${success}</c:if>
<br><br>
<form action="/MyProject/uploadfile" method="post" enctype="multipart/form-data">
<br><br>
Upload a file:
<input type="file" name="file"><br><br>
<input type="submit" value="Upload"> Press here to upload the file!
</form>

<a href=./mainPage>Back to main page</a>
</body>
</html>