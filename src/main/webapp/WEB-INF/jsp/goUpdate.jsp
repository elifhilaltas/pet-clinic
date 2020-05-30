<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Go Update</title>
</head>
<body>

	<form:form modelAttribute="owner" method="post">
	
	id : <form:input path="id"/><br>
	<form:button name="submit">Go Update</form:button>
	
	</form:form>

</body>
</html>