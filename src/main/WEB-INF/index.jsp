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
    <title>Books!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Here are books</h1>
   <a href="/book/new"><button>New Book</button></a>
   <h3>Drink List</h3>
   <c:forEach var="book" items="${allBooks}">
   		<div>
   			<c:out value="${book.title}"></c:out>
   			<a href="/book/${ book.id}/update"><button>Edit</button></a>
   			<form action="/book/${book.id}/update" method="POST">
   				<input type="hidden" name="_nethod" value="delete"/>
   				<button>Delete</button>
   			</form>
   		</div>
   		<p><c:out value="${book.desc}"></c:out></p>
   		<p><c:out value="${book.lang}"></c:out></p>
   		<p><c:out value="${book.numOfPages}"></c:out></p>
   </c:forEach>
</body>
</html>
