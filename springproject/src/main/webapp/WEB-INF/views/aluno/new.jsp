<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<s:url value="/aluno/salvar" var="salvar"/>
	<form:form action="${salvar}" modelAttribute="aluno">
		<div>
			<label for="nome">Nome</label>
			<form:input path="nome"/>
		</div>
		
		<div>	
			<label for="matricula">Matricula</label>
			<form:input path="matricula"/>
		</div>
		
		
		<div>
		<form:select path="professores" multiple="true" >
			<form:option value="" label="--- Select ---"/>
			<form:options items="${professores}" itemValue="id" itemLabel="nome" />
		</form:select>
		</div>
		
		<div>	
			<input type="submit" value="salvar"/>
		</div>
	
	</form:form>
	


</body>
</html>