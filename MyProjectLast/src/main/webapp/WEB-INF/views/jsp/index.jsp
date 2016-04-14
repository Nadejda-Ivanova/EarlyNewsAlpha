<%@page import="com.example.model.Image"%>
<%@page import="com.example.model.Article"%>
<%@page import="java.util.ArrayList"%>
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
    <div > <jsp:include page="head.jsp"></jsp:include>  </div>
<% 
ArrayList<Article> artList1= (ArrayList<Article>)session.getAttribute("artList1");
ArrayList<Article> artList2= (ArrayList<Article>)session.getAttribute("artLIst2");
ArrayList<Article> artList3= (ArrayList<Article>)session.getAttribute("artList3");
ArrayList<Image> img1= (ArrayList<Image>)session.getAttribute("imgList1");
ArrayList<Image> img2= (ArrayList<Image>)session.getAttribute("imgList2");
ArrayList<Image> img3= (ArrayList<Image>)session.getAttribute("ImgList3");

                       String cat1=(String)session.getAttribute("cat1");
                        String cat2=(String)session.getAttribute("cat2");
                         String cat3=(String)session.getAttribute("cat3");
                       %>
    </div>
    <div class="row">
        <div class="col-lg-3">
        <h3><%=cat1 %></h3>
        
            <div class="list-group">
<%
				int i=0;
	            for(Article article1:artList1){
	            	request.setAttribute("parameter", article1.getId());
         	   request.setAttribute("title", article1.getTitle());
         	   request.setAttribute("img", img1.get(i).getName());
         	   i++;
            %>
             <jsp:include page="ShowArticleForHead.jsp"></jsp:include>
           <% }
            %>
                
            </div>
        
        
    
        
    </div>
</div>

</body>
</html>