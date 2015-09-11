<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>${sucesso}</h1>


	<c:url value="/person/save" var="save"/>
	
	<s:hasBindErrors name="person">
		
		<ul>
		<c:forEach var="error" items="${errors.allErrors}">
			
			<li><s:message  message="${error}" />-${error.field}</li>
		</c:forEach>
		</ul>
	
	</s:hasBindErrors>
	

	<form:form action="${save}" method="Post" modelAttribute="person">
		
		<div>
			<label for="name">Name</label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</div>	
		<div>
			<label for="cpf">Cpf</label>
			<form:input path="cpf"/>
			<form:errors path="cpf"/>
		</div>
		<div>
			<label for="email">Email</label>
			<form:input path="email"/>
			<form:errors path="email"/>
		</div>
		
		<div>
			<label for="street">Street</label>
			<form:input path="address.street"/>
			<form:errors path="address.street"/>
		</div>
		
		<div>
			<label for="cep">Cep</label>
			<form:input path="address.cep"/>
			<form:errors path="address.cep"/>
		</div>
		
		<div>
			<input type="submit" value="Salvar"/>
		</div>
	</form:form>

</body>
</html>