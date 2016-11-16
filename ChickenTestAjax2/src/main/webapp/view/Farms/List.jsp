    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/estilo.css"/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farm administration</title>

</head>
<body>

<h3>Farm List</h3>


<table>
<thead>
<tr>
<th>Farm name</th>
<th>Chickens</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>
<tbody id="results">
</tbody>

</table>
<br>
<button id="new"> Add New Farm</button>

<button id="reload"> Recargar</button>

<div id="FormDiv">
<form action="" method="post"  id="Form">
		<h3 id="title">New Farm</h3>
		
		<label >Name: </label>
		<input type="text" id="name"/>
		<span id="nameError" class="error"></span>
		
		<br><br>
	
		<button  id="submit"> OK </button>
	</form>

</div>




<script type="text/javascript">

$(document).ready(function(){
	
	loadList();	
	
	$("#FormDiv").hide();
	

	$("#nameError").hide();
	
	$("#cancel").on("click", function(){
		$("#FormDiv").hide()});
	
	$("table").on("click",".delete", function(){
		var url= "Delete/"+$(this).attr('id')	
		
		$.ajax({
			url: url,
			success: loadList
			})
				
		});
	
	$("#new").on("click", function(){
		$("#Form").removeClass("Update").addClass("New");
		$("#title").text("New Farm");

		$("#FormDiv").toggle();

		
	});
	
	$("#Form").on("submit", function(e){
		
		
		
		e.preventDefault();
		
		
		if($("#Form").hasClass("New")){
		
		
		
		if(isNameOk()){
			
					
		var farm = {
				name: $("#name").val()
				}
		
			
		$.ajax({
			url: "New",
			type: "POST",
			data: farm,
			success: function(data){
				loadList()
				$("#name").val("")
				$("#FormDiv").hide();
			}
		})
					
					
		}}
		
		if($("#Form").hasClass("Update")){
			
			if(isNameOk()){
			
			
			var farm = {
					
					id: $("#name").attr('FarmID'),
					name: $("#name").val()
					}
			
				
			$.ajax({
				url: "Update",
				type: "POST",
				data: farm,
				success: function(data){
					loadList()
					$("#FormDiv").hide();
					$("#name").val("");

				}
			})
						
						
			}}})
		
		
		});	
		
		
		
	
	$("#reload").on("click", function(){
		loadList();
					
		});
	
	$("#name").blur(function(){
		
		isNameOk();
		});
	
	
	//UPDATE
	
	$("table").on("click",".update", function(){
		$("#Form").removeClass("New").addClass("Update");
		$("#title").text("Modify Farm");

		$("#FormDiv").show();
		
		$("#name").val($(this).attr('name'));
		$("#name").attr('FarmID', $(this).attr('id'));


	});
	

	
	
	function isNameOk(){
		
		var name = $("#name").val();
		
		if(name.length >15){
				
			$("#nameError").html("Name must be less than 15 characters");
			$("#nameError").show();
			
			return false;
			}else{
		
		if ($.trim(name).length == 0) {
				  
				  $("#nameError").html("Name can't be empty");
					$("#nameError").show();
					
					return false;
				  			  
				  
			  }else{
			$("#nameError").hide();
			return true;
		}
		
		}}
		
		


function loadList(){
	
	$.getJSON("list",
		
		function(data){
		fillTable(data);
	})
};

function fillTable (data){
	$("#results").empty();
	for(var index in data){
		$("#results").append(
				$('<tr>')
				.append(
						$("<td>").append( data[index].name )
						)
				.append(
						$('<td>').append( "<a href=\"<%=request.getContextPath()%>/Chickens/"+ data[index].id +"\"> Show List </a> ")
						)
				.append(
						$("<td>").append( "<button class=\"update\" name=\""+data[index].name+"\" id=\""+ data[index].id +"\"> Update </button> ")
						)
				.append(
						$("<td>").append( "<button class=\"delete\" id=\""+ data[index].id +"\"> Delete </button> ")
						))
	}
}
		

	
</script>
</body>
</html>