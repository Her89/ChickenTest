    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farm administration</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css"/>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery.i18n.properties.js"></script>
	
</head>
<body>

<br>
<a href="<%=request.getContextPath()%>/Farms/?language=en">Go to Farm List</a>
<br>
<br>
<br>

<a href="<%=request.getContextPath()%>/Farms/?language=es">Ver Lista de Granjas</a>


<script>
</script>

</body>
</html>