<%@page import="java.awt.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.example.model.Image"%>
<%@page import="com.example.model.Article"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" 
    href="<c:url value="/css/bootstrap.min.css"/> "
    />
    <link rel="stylesheet" type="text/css" href="
      <c:url value="/css/custom.css"/> "/>
    <link rel="stylesheet" type="text/css" href="
      <c:url value="css/basic-template.css"/> "/>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<%
                       ArrayList<Image>cat=(ArrayList<Image>)session.getAttribute("imgList");
 session.setAttribute("cat",cat);
                       
                    	%>
<div > <jsp:include page="head.jsp"></jsp:include>  </div>
<div class="container-fluid" style="height:1000px">

 

                       <%
                     
                      ArrayList<Article>art=(ArrayList<Article>)session.getAttribute("artList");
                       ArrayList<Image> img=(ArrayList<Image>)session.getAttribute("imgList");
                       %>
                       
                       
                   
                       
                       
                       
                    
                       <div class="container">

        <div class="row">

            <div class="col-lg-12">
                <h1 class="page-header">${category}</h1>
            </div>
            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<%
				int i=0;
	            for(Article article:art){
	            	request.setAttribute("parameter", article.getId());
         	   request.setAttribute("title", article.getTitle());
         	   request.setAttribute("img", img.get(i).getName());
         	   i++;
            %>
             <jsp:include page="testJSP.jsp"></jsp:include>
           <% }
            %>
            </div>
        </div>

        <hr>
                    	
                    	
                       
                       
                       
</div>

</body>
</html>