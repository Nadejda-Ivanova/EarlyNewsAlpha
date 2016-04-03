<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>UPLOAD JSP</h1>
<h4>Upload Pictures</h4>
<!-- OT ZDRAVKO -->
 <spring:form method="post" action="./savefiles"
            modelAttribute="uploadForm" enctype="multipart/form-data">

<spring:input type="file" path="files[0]"/>
<br>
<br>
<spring:input type="file" path="files[1]"/>
<br>
<br>
<spring:input type="file" path="files[2]"/>
<br>
<br>
<spring:input type="file" path="files[3]"/>
<br>
<br>
<spring:input type="file" path="files[4]"/>
<br>
<br>
<spring:input type="file" path="files[5]"/>
<br>
<br>
<spring:input type="file" path="files[6]"/>
<br>
<br>
<spring:input type="file" path="files[7]"/>
<br>
<br>
<spring:input type="file" path="files[8]"/>
<br>
<br>
<spring:input type="file" path="files[9]"/>
<br>
<br>
<spring:input type="submit" value="Upload"/>

</spring:form >







</body>
</html>