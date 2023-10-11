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
	<form:form action="save" modelAttribute="employee">
		ID:<form:input path="eNo"/>
		Name:<form:input path="name"/>
		Mobile:<form:input path="mobileNo"/>
		Email:<form:input path="email"/>
		Password:<form:password path="password"/>
		<form:button>save</form:button>
	</form:form>

</body>
</html>