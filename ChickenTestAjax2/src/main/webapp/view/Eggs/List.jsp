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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scriptE.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.EggList" /></title>

</head>
<body>
<a href="?language=es"> Español</a> | 
<a href="?language=en"> English</a>
<br><br>	
<h3><spring:message code="title.EggList" />:</h3>


<table>
<thead>
<tr>
<th><spring:message code="Color" /></th>
<th><spring:message code="Update" /></th>
<th><spring:message code="Delete" /></th>
</tr>
</thead>
<tbody id="results">
</tbody>

</table>
<br>
<div id="noInfo" class="error"></div>
<br><br>	
<button id="new"><spring:message code="NewEgg" /></button>


<div id="FormDiv">
<form action="" method="post"  id="Form">
		<h3 id="title"><spring:message code="NewEgg" /></h3>
		
		<label ><spring:message code="Color" /> </label>
		<input type="text" id="name"/>
		<span id="nameError" class="error"></span>
		
		<br><br>
	
		<button  id="submit"> OK </button>
	</form>

</div>
<br><br>
<a href="" id="return"> <spring:message code="Return" /> </a>

	
</body>
</html>