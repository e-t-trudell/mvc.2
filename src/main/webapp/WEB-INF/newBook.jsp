<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
 
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>new books!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Create a new Book</h1>
   <form:form action="/book/create" method="POST" modelAttribute="book">
   	<div>
   		<form:label path="title">Title: </form:label>
   		<form:input path="title"></form:input>
   		<form:errors path="title"></form:errors>
   	</div>
   	<div>
   		<form:label path="description">Description: </form:label>
   		<form:input path="description"></form:input>
   		<form:errors path="description"></form:errors>
   	</div>
   	<div>
   		<form:label path="language">Language: </form:label>
   		<form:input path="language"></form:input>
   		<form:errors path="language"></form:errors>
   	</div>
   	<div>
   		<form:label path="numberOfPages">Number of Pages: </form:label>
   		<form:input path="numberOfPages"></form:input>
   		<form:errors path="numberOfPages"></form:errors>
   	</div>
   	<button>Submit</button>
   </form:form>
   <h3>New Books:</h3>
</body>
</html>
