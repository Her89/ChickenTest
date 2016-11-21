    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/estilo.css"/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/scriptE.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Egg List</title>

</head>
<body>

<h3>Egg List :</h3>


<table>
<thead>
<tr>
<th>Color</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>
<tbody id="results">
</tbody>

</table>

<br>
<button id="new"> Add New Egg</button>

<button id="reload"> Recargar</button>

<div id="FormDiv">
<form action="" method="post"  id="Form">
		<h3 id="title">New Egg</h3>
		
		<label >Color: </label>
		<input type="text" id="name"/>
		<span id="nameError" class="error"></span>
		
		<br><br>
	
		<button  id="submit"> OK </button>
	</form>

</div>





<script type="text/javascript">



	
</script>
</body>
</html>