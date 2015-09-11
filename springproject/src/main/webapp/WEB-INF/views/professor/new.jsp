<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastre um Professor</title>
</head>
<body>


	<s:url value="/professor/salvar" var="salvar"/>
	
	
	<h2>${sucesso}</h2>
	
	
	<form:form action="${salvar}" modelAttribute="professor">
		
		<div>
			<label for="nome">Nome</label>
			<form:input path="nome"/>
		</div>
		<div>
			<label for="titulo">Titulo</label>
			<form:input path="titulo"/>
		</div>
		
		<div>
			<input type="submit" value="salvar">
		</div>
	</form:form>
	
		

</body>
</html>