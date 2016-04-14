<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" 
    href=<c:url value="/css/bootstrap.min.css"/> 
    >
    <link rel="stylesheet" type="text/css" href=
      <c:url value="/css/custom.css"/> >
    <link rel="stylesheet" type="text/css" href=
      <c:url value="css/basic-template.css"/> >
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<div>

                <a class="thumbnail" href="article3?artID=<%=request.getAttribute("parameter")%>">
                
                    <img class="img-responsive" src="img/ <%=request.getAttribute("img")%>" width="400" height="300">
                    <h2> <%=request.getAttribute("title")%> </h2>
                </a>
            </div>

<hr/>