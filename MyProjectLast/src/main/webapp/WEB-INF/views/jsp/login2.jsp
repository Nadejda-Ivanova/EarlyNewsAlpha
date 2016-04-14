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
    <link rel="stylesheet" type="text/css" href="
      <c:url value="/css/bootstrap.min.css"/> "/>
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


<div class="row">

        <div class="Absolute-Center is-Responsive">

            <div class="col-sm-12 col-md-10 col-md-offset-1">
<spring:form method="post" commandName="user">
	


<div class="form-group input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                       <spring:input type="text" path="name"  placeholder="username"/>
                       
                       
                    </div>
                    
                    
                    <div class="form-group input-group">
                        <span class="input-group-addon">@<i class="glyphicon "></i></span>
                       <spring:input type="password" path="password" placeholder="password"/>
                    </div>
                    <div>
                    <c:if test="${not empty errorMessage}">
                       <p style='color:red'>
                       <c:out value="${errorMessage}"/>
                       </p>
                       
                       
                       </c:if>
                    </div>
                    <div class="form-group">
                         <input type="submit" class="btn btn-def btn-block" value="Login"/>
                      
                    </div>
                   






</spring:form>
 </div>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="js/bootstrap.min.js"/>></script>
</body>
</html>
