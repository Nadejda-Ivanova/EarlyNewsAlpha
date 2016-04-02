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
<h1>UPLOAD JSP</h1>
<h4>Upload Pictures</h4>

 <spring:form method="post" action="./savefiles"
            modelAttribute="uploadForm" enctype="multipart/form-data">

<input type="file" name="files[0]">
<br>
<br>
<input type="file" name="files[1]">
<br>
<br>
<input type="file" name="files[2]">
<br>
<br>
<input type="file" name="files[3]">
<br>
<br>
<input type="file" name="files[4]">
<br>
<br>
<input type="file" name="files[5]">
<br>
<br>
<input type="file" name="files[6]">
<br>
<br>
<input type="file" name="files[7]">
<br>
<br>
<input type="file" name="files[8]">
<br>
<br>
<input type="file" name="files[9]">
<br>
<br>
<input type="submit" value="Upload">

</spring:form >







</body>
</html>