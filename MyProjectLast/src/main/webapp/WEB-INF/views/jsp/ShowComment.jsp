<%@page import="java.util.ArrayList"%>
<%@page import="com.example.model.Comment"%>
<%@page import="com.example.model.Article"%>
<%@page import="com.example.model.Image"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
                       ArrayList<Image>cat=(ArrayList<Image>)session.getAttribute("imgList");
 session.setAttribute("cat",cat);
                       
                    	%>
<div > <jsp:include page="head.jsp"></jsp:include>  </div>
<div class="container-fluid" style="height:1000px">

 

                    
                       <%
                       List<Comment>art=(List<Comment>)session.getAttribute("artList");
                       for(Comment article:art){
                    	   request.setAttribute("title", article.getText());
                       %>
                        <jsp:include page="testJSP.jsp"></jsp:include>
                      <% }
                       %>
                       
                   
                       
                       
                       
                    
                       
                       
                       
                       
</div>

</body>
</html>