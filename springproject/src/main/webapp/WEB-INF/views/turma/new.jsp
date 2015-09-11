<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="s" %>


<h1>Form Truma</h1>


<s:url value="/turma/salvar" var="salvar"/>


<h1>${sucesso}</h1>


<form:form method="post" action="${salvar}" modelAttribute="turma">

		
	<div>
		<label for="codigo">Codigo</label>
		<form:input path="codigo" />
	</div>

	<div>
		<label for="sala">Sala</label>
		<form:input path="sala" /> 
	</div>
	
	<div>
		<label for="horario">Horário</label>
		<form:input type="time" path="horario"/>
	</div>
	
	<div>
		<form:select path="professores.id" >
		    <form:option value="" label="--- Select ---"/>
			<form:options items="${professores}" itemValue="id" itemLabel="nome"/>
		</form:select>
	</div>
	
	<div>
		<input type="submit" value="salvar"/>
	</div>
	
</form:form>