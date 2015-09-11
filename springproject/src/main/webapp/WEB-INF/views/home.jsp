<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:url value="/person/new" var="novo"/>
	<c:url value="/turma/new" var="novo_turma"/>
	<c:url value="/professor/novo" var="novo_professor"/>
	<c:url value="/aluno/novo" var="novo_aluno"/>
	
	<a href="${novo}">novo</a>
	<a href="${novo_turma}">novo turma</a>
	<a href="${novo_professor}">novo professor</a>
	<a href="${novo_aluno}">novo aluno</a>
</body>
</html>