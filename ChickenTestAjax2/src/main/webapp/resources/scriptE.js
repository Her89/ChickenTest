
var url = window.location.href.toString();
var parts = url.split("/");
var chickenId = parts[parts.length-1];

$(document).ready(function(){
	 $.ajaxSetup({ cache: false });


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
		$("#title").text("New Egg");
		$("#name").val("");
		$("#FormDiv").show();

		
	});
	
	$("#Form").on("submit", function(e){
		
		
		
		e.preventDefault();
		
		
		if($("#Form").hasClass("New")){
		
		
		
		if(isNameOk()){
			
					
		var egg = {
				color: $("#name").val(),


				}
		
			
		$.ajax({
			url: "New/"+chickenId,
			type: "POST",
			data: egg,
			success: function(data){
				loadList()
				$("#name").val("")
				$("#FormDiv").hide();
			}
		})
					
					
		}}
		
		if($("#Form").hasClass("Update")){
			
			if(isNameOk()){
			
			
			var egg = {
				
					id: $("#name").attr("eggId"),
					color: $("#name").val()
					}
			
				
			$.ajax({
				url: "Update/"+chickenId,
				type: "POST",
				data: egg,			

				
				success: function(data){
					loadList()
					$("#FormDiv").hide();
					$("#name").val("");

				}

			})
						
						
			}}})
		
		
		
		
		
		
	
	$("#reload").on("click", function(){
		loadList();
					
		});
	
	$("#name").blur(function(){
		
		isNameOk();
		});
	
	
	//UPDATE
	
	$("table").on("click",".update", function(){
		$("#Form").removeClass("New").addClass("Update");
		$("#title").text("Modify Egg");

		$("#FormDiv").show();
		
		$("#name").val($(this).attr('name'));
		$("#name").attr('eggID', $(this).attr('id'));


	});
	
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
	
	var url= "list/"+chickenId;
	
	$.getJSON(url,
		
		function(data){
		fillTable(data);
		
		
	})
};

function fillTable (data){
	$("#results").empty();

	for(var index in data.eggList){
		$("#results").append(
				$('<tr>')
				.append(
						$("<td>").append( data.eggList[index].color )
						)
				.append(
						$("<td>").append( "<button class=\"update\"  name=\""+data.eggList[index].color+"\" id=\""+ data.eggList[index].id +"\"> Update </button> ")
						)
				.append(
						$("<td>").append( "<button class=\"delete\" id=\""+ data.eggList[index].id +"\"> Delete </button> ")
						))
	}
}
		