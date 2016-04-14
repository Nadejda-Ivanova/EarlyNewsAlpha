<%@page import="com.example.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
<script>
function newDoc() {
    window.location.assign("http://localhost:8080/MyProject/search")
}
</script>
<div class="navbar  navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
        
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </button>
            <div ><a href="/MyProject/"><img id="img" src=<c:url value="img/images.jpg"/> ></a></a></div>

        </div>
        
                       <%
                       ArrayList<Category>cat=(ArrayList<Category>)session.getAttribute("catList");
                    	%>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav  ">
          <%    for(Category cateory:cat){
                    	   
                      %>
                          <li ><a href="/MyProject/article?category=<%=cateory.getName()%>"><%=cateory.getName()%></a> </li>
                      <% }
                       %>
                       <li ><a href="/MyProject/login"> Login</a></li>
                       <li><a href="/MyProject/services/allarticles">Service</a></li>
            </ul>
            <div class="nav navbar-nav navbar-right">
            <form class="navbar-form" role="search" action="search">
                <div class="input-group">
                 <input title="sdfdfdsfsd"   type="text" class="form-control" placeholder="Search" name="<c:url value="search"/>" id="./srch-term">

                    <div class="input-group-btn">
                        <button  value="Load new document" onclick="newDoc()" class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                    
                </div>
              
            </form>
            
            
            
                </div>
        </div>


</div>

</div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="js/bootstrap.min.js"/>></script>
</body>
</html>