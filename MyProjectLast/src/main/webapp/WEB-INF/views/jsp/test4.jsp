<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="com.example.model.Image"%>
<%@page import="com.example.model.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
                       List<Image>cat=(List<Image>)session.getAttribute("imgList");
 session.setAttribute("cat",cat);
                       
                    	%>
<div > <jsp:include page="head.jsp"></jsp:include>  </div>
<div class="container-fluid" style="height:1000px">

 
<p style='color:red'>
                  
                       <%
                      
                   
                   	Map<Article,ArrayList<Image>>a=(Map<Article,ArrayList<Image>>)session.getAttribute("art");
                    	  // request.setAttribute("title", art.get(0).getName());
                    	   for(Article key : a.keySet()) {
                    		   if(a.get(key).get(0).getName()!=null){
	                    		   request.setAttribute("title", a.get(key).get(0).getName());
	                    		   request.setAttribute("title1", key.getTitle());
                    		   }
                    		}
                     
                       %>
                       
                     
                       </p>
                       
                       
                       
                       
                       
                       
                       
                       
</div>

</body>
</html>