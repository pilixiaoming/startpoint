<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- <link rel="stylesheet" href="<%request.getContextPath()%>/resources/css/main.css" type="text" /> --%>
</head>
<body>
Hello ${loginUser.name }
<a href="add">add user</a>

<br/>
	<c:forEach items="${users}" var="user">
	<a href="${user.value.name }">See user details</a>
	---${user.value.name } 
	---${user.value.email }
	---${user.value.title }
	<a href="${user.value.name }/update">Update user</a>
	<a href="${user.value.name }/delete">Delete user</a>
	 <br/>
	</c:forEach>
</body>
</html>