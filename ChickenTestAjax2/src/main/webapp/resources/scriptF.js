var url = window.location.href.toString();
var parts = url.split("=");
var lang = parts[1];

$(document).ready(function(){

	jQuery.i18n.properties({
	    name: 'messages', 
	    path: contextPath+'/resources/messages/', 
	    mode: 'both',
	    language: lang
	     
	});

	
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
		$("#title").text($.i18n.prop('NewFarm'));
		$("#name").val("");
		$("#FormDiv").show();

		
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
						
						
			}}});
		
			
	$("#name").blur(function(){
		
		isNameOk();
		});
	
	
	//UPDATE
	
	$("table").on("click",".update", function(){
		$("#Form").removeClass("New").addClass("Update");
		$("#title").text($.i18n.prop('ModifyFarm'));

		$("#FormDiv").show();
		
		$("#name").val($(this).attr('name'));
		$("#name").attr('FarmID', $(this).attr('id'));


	});
	
});	
	
	
	function isNameOk(){
		
		var name = $("#name").val();
		
		if(name.length >15){
				
			$("#nameError").html($.i18n.prop('eNameLength'));
			$("#nameError").show();
			
			return false;
			}else{
		
				
		if ($.trim(name).length == 0) {
				  
				  $("#nameError").html($.i18n.prop('eNameNull'));
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
}

function fillTable (data){
	$("#results").empty();
	for(var index in data){
		$("#results").append(
				$('<tr>')
				.append(
						$("<td>").append( data[index].name )
						)
				.append(
						$('<td>').append( "<a href=\"../Chickens/"+ data[index].id +"\"> "+$.i18n.prop('a.List')+" </a> ")
						)
				.append(
						$("<td>").append( "<button class=\"update\" name=\""+data[index].name+"\" id=\""+ data[index].id +"\">"+$.i18n.prop('th.Update')+" </button> ")
						)
				.append(
						$("<td>").append( "<button class=\"delete\" id=\""+ data[index].id +"\"> "+$.i18n.prop('th.Delete')+" </button> ")
						))
	}
}
		

