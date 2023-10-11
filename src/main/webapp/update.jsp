<%@page import="spring_mvc.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Employee e = (Employee) request.getAttribute("emp");
	%>
	<form:form action="edit" modelAttribute="emp">
		ID:<form:input path="eNo" value="<%=e.geteNo()%>" readonly="readonly"/>
		Name:<form:input path="name" value="<%=e.getName()%>"/>
		Mobile:<form:input path="mobileNo" value="<%=e.getMobileNo()%>"/>
		Email:<form:input path="email"  value="<%=e.getEmail()%>" readonly="readonly"/>
		Password:<form:input path="password" value="<%=e.getPassword()%>"/>
		<form:button>save</form:button>
	</form:form>
	
</body>
</html>