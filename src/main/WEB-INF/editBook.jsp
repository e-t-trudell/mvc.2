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
    <title>edits</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Edit new Book</h1>
   <form:form action="/book/${book.id}/update" method="POST" modelAttribute="book">
   	<input type="hidden" name="_method" value="put" />
   	<input type="hidden" name="id" value="${book.id}" />
   	<div>
   		<form:label path="title">Title: </form:label>
   		<form:input path="title" value="${ book.title }"></form:input>
   		<form:errors path="title"></form:errors>
   	</div>
   	<div>
   		<form:label path="desc">Description: </form:label>
   		<form:input path="desc" value="${ book.desc }"></form:input>
   		<form:errors path="desc"></form:errors>
   	</div>
   	<div>
   		<form:label path="lang">Language: </form:label>
   		<form:input path="lang" value="${ book.lang }"></form:input>
   		<form:errors path="lang"></form:errors>
   	</div>
   	<div>
   		<form:label path="numOfPages">Number of Pages: </form:label>
   		<form:input path="numOfPages" value="${ book.numOfPages }"></form:input>
   		<form:errors path="numOfPages"></form:errors>
   	</div>
   	<button>Submit</button>
   </form:form>
   <a href="/"><button>Home</button></a>
</body>
</html>
