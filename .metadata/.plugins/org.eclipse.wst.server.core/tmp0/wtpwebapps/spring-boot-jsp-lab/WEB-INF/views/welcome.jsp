<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing JSP</title>
</head>
<body>
<h1>Hello World !</h1>
<p>This is my first JSP page</p>
<%
String serverTime = new java.util.Date().toString();
String name = "Muzaffar";
%>
<p>Server time : <%= serverTime %></p>
<p>Author of this page is <%= name %></p>
</body>
</html>
