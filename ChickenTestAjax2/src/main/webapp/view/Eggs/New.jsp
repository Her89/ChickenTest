<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/estilo.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Egg</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
</head>
<body>

<h3>New Egg for <c:out value="${chicken.name}"></c:out></h3>

<form:form action="../New" method="post" modelAttribute="egg" id="form">
		<form:label path="color">Color: </form:label>
		<form:input path="color" id="color" />
		<span id="colorError" class="error"></span>
		<br>
		<br>
		
		<form:input type="hidden" path="chicken.id" value="${chicken.id}" />

		<input type="submit" value="Add" />
	</form:form>

<br>
<a href="<%=request.getContextPath()%>/Eggs/${chicken.id}"><button>Cancel</button></a>



<script>
$(document).ready(function(){
	
	$("#colorError").hide();
	var colorError = false;


	$("#color").blur(function(){
		
		checkColor();
		});
	
	
	function checkColor(){
		
		var color = $("#color").val();
		
		colorError = false;
		
		if(color.length >10){
			
			$("#colorError").html("Color must be less than 10 characters");
			$("#colorError").show();
			colorError = true;
		}else{
		
		if ($.trim(color).length == 0) {
				  
				  $("#colorError").html("Color can't be empty");
					$("#colorError").show();
					colorError = true;
				  			  
				  
			  }else{
			$("#colorError").hide();
		}}}
		
		
	
	$("form").submit(function(event){
	
		
		
		colorError=false;
		checkColor();
		
		if(colorError == false){
			return true;}
		else{
			return false;}
		
});
});


	


</script>

</body>
</html>