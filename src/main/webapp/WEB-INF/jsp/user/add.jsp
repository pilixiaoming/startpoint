<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${users}" var="user">
	${user.value.name } <br/>
	${user.value.email } <br/>
	${user.value.title } <br/>
	</c:forEach>
	<sf:form method="post" modelAttribute="user" enctype="multipart/form-data" >
		name: <sf:input path="name" /> <sf:errors path="name"/><br />
		email: <sf:input path="email" /> <sf:errors path="email"/><br />
		title: <sf:input path="title" /> <sf:errors path="title"/><br />
		Attach: <input type="file" name="file"/><br/>
		<br />
		<input type="submit" value="gogogo">
	</sf:form>
</body>
</html>