

<%@page import="java.util.ArrayList"%>
<%@page import="com.example.model.Image"%>
<%@page import="com.example.model.Article"%>
<%@page import="com.example.model.Comment"%>
<%@page import="java.util.List"%>
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
                       List<Image>cat=(List<Image>)session.getAttribute("imgList");
 session.setAttribute("cat",cat);
                       
                    	%>
<div > <jsp:include page="head.jsp"></jsp:include>  </div>
<div class="container-fluid" style="height:1000px">

 

                    
                       <%
                       ArrayList<Comment> coments= (ArrayList<Comment>)session.getAttribute("coments");
                       String a=(String)session.getAttribute("gorko");
                       Image img=(Image)session.getAttribute("image");
                       Article art=(Article)session.getAttribute("article");
                       
                    	%>
                    	
<div class="row">

        <div  >

            <div class="col-sm-12 " align="left">

           <% int i=0;
            
           %>
      	  
      	 <h1> <%=art.getTitle() %></h1>
      	 <br><br>
                    <img class="img-responsive"  src="img/<%=img.getName()%>" width="400" height="300">
                  
             <br><br>       
                    <h3> <%=art.getText() %></h3>
               
      	  

      	
                    
                       <br><br>
                         <h4>Comments:</h4> 
                      <% for(Comment com:coments){
                    	%>
                    	<h5> <%=com.getAuthor()%></h5>
                    	<h6> <%=com.getText()%></h6>
                    	
                    <%  }
                      %>
                    
                   
                       







 </div>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="js/bootstrap.min.js"/>></script>
                    	
                    	
                    	 
                     
                       
                    
                    	
                       
                   
                       
                       
                       
                    
                       
                       
                       
                       
</div>

</body>
</html>