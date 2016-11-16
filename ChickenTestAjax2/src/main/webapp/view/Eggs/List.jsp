    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/estilo.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Egg List</title>
</head>
<body>

<h3>Egg List for <c:out value="${chicken.name}"></c:out></h3>

<c:if test="${empty chicken.eggList}">

<b>There is no information available</b>

<br><br>
</c:if>

<c:if test="${!empty chicken.eggList}">

<table>
<tr>
<th>Color</th>
<th>Update</th>
<th>Delete</th>
</tr>
<c:forEach items="${chicken.eggList}" var="egg">
<tr>
<td><c:out value="${egg.color}"></c:out></td>
<td><a href="<%=request.getContextPath()%>/Eggs/Update/${egg.id}">Update </a> </td>
<td><a href="<%=request.getContextPath()%>/Eggs/Delete/${egg.id}">Delete </a> </td>

</c:forEach>
</table>
<h4>Total eggs: <c:out value="${chicken.eggList.size()}"></c:out></h4>
</c:if>

<a href="<%=request.getContextPath()%>/Eggs/New/${chicken.id}"><button> Add New Egg</button></a>

<br>
<br>

<a href="<%=request.getContextPath()%>/Chickens/${chicken.farm.id}">Back to Chicken List</a>

</body>
</html>