<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Egg</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/estilo.css"/>

</head>
<body>

<h3>Update Egg for <c:out value="${egg.chicken.name}"></c:out></h3>

<form:form action="../Update" method="post" modelAttribute="egg">
		<form:label path="color">Color:   </form:label>
		<form:input path="color" value="${egg.color}" id="color" />
				<span id="colorError" class="error"></span>
		
		<br>
		<form:label path="chicken.id">Chicken: </form:label>
		
		<form:select path="chicken.id" value="${egg.chicken.id}">
			<c:forEach items="${farm.chickenList}" var="chicken">
				<form:option value="${chicken.id}">
					<c:out value="${chicken.name}"></c:out>
				</form:option>
			</c:forEach>
			</form:select>
		<br>
		<br>
		
		<form:input type="hidden" path="id" value="${egg.id}" />
		

		<input type="submit" value="Update" />
	</form:form>

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