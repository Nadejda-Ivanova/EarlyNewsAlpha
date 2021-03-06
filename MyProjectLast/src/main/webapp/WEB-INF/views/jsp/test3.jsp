<%@page import="com.example.model.Image"%>
<%@page import="com.example.model.Article"%>
<%@page import="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link rel="stylesheet" type="text/css" href="
      <c:url value="/css/bootstrap.min.css"/> "/>
    <link rel="stylesheet" type="text/css" href="
      <c:url value="/css/custom.css"/> "/>
    
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
 
<div > <jsp:include page="head.jsp"></jsp:include>  </div>

 

                  
                       <%
                       List<Image>art=(List<Image>)session.getAttribute("imgList");
                       
                    	%>
                       
                     

        
       
     

                
  <div class="container">
   
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">

            <div class="item active">
                <a href="/MyProject/article3?artID=7  " ><img src="img/7.jpg" class="center-block" alt="Ninetails" width="460" height="345"></a>
                <div class="carousel-caption">
                   
                </div>
            </div>

            <div class="item">
                <a href="/MyProject/article3?artID=1  " ><img src="img/1.jpg" class="center-block" alt="Ninetails" width="460" height="345"></a>
                <div class="carousel-caption">
                    
                </div>
            </div>

            <div class="item">
                <a href="/MyProject/article3?artID=8  " ><img src="img/8.jpg" class="center-block" alt="Ninetails" width="460" height="345"></a>
                <div class="carousel-caption">
                   
                </div>
            </div>

            <div class="item">
                <a href="/MyProject/article3?artID=13 " ><img src="img/13.jpg" class="center-block" alt="Ninetails" width="460" height="345"></a>
                <div class="carousel-caption">
                   
                </div>
            </div>

        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

</div>
<div > <jsp:include page="footer.jsp"></jsp:include>  </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>