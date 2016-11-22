    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css"/>

<script>var contextPath = "${pageContext.request.contextPath}"</script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery.i18n.properties.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scriptC.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="ChickenList" /></title>

</head>
<body>
<a href="?language=es"> Español</a> | 
<a href="?language=en"> English</a>
<br><br>
<h3 id="titleTop"><spring:message code="Farm" />: </h3>

<h3><spring:message code="ChickenList" />:</h3>


<table>
<thead>
<tr>
<th><spring:message code="Name" /></th>
<th><spring:message code="TotalEggs" /></th>
<th><spring:message code="EggList" /></th>
<th><spring:message code="Update" /></th>
<th><spring:message code="Delete" /></th>
</tr>
</thead>
<tbody id="results">
</tbody>

</table>

<br><br>	
<button id="new"> <spring:message code="NewChicken" /></button>

<div id="FormDiv">
<form action="" method="post"  id="Form">
		<h3 id="title"><spring:message code="NewChicken" /></h3>
		
		<label ><spring:message code="Name" /> </label>
		<input type="text" id="name"/>
		<span id="nameError" class="error"></span>
		
		<br><br>
	
		<button  id="submit"> OK </button>
	</form>

</div>
<br>
<br><br>
<a href="${pageContext.request.contextPath}/Farms/?language=${param.language}"> <spring:message code="Return" /> </a>




</body>
</html>