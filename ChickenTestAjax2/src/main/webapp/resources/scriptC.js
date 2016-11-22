
var url = window.location.href.toString();
var parts = url.split("/");
var farmId = parts[parts.length-1];
var langParts = url.split("=");
var lang = langParts[1];

$(document).ready(function(){

	 $.ajaxSetup({ cache: false });
	 
	 jQuery.i18n.properties({
		    name: 'messages', 
		    path: contextPath+'/resources/messages/', 
		    mode: 'both',
		    language: lang
		     
		});

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
		$("#title").text($.i18n.prop('NewChicken'));
		$("#name").val("");
		$("#FormDiv").show();

		
	});
	
	$("#Form").on("submit", function(e){
		
		
		
		e.preventDefault();
		
		
		if($("#Form").hasClass("New")){
		
		
		
		if(isNameOk()){
			
					
		var chicken = {
				name: $("#name").val(),


				}
		
			
		$.ajax({
			url: "New/"+farmId,
			type: "POST",
			data: chicken,
			success: function(data){
				loadList()
				$("#name").val("")
				$("#FormDiv").hide();
			}
		})
					
					
		}}
		
		if($("#Form").hasClass("Update")){
			
			if(isNameOk()){
			
			
			var chicken = {
				
					id: $("#name").attr("chickenId"),
					name: $("#name").val()
					}
			
				
			$.ajax({
				url: "Update/"+farmId,
				type: "POST",
				data: chicken,			

				
				success: function(data){
					loadList()
					$("#FormDiv").hide();
					$("#name").val("");

				}

			})
						
						
			}}})
		
		
	$("#name").blur(function(){
		
		isNameOk();
		});
	
	
	//UPDATE
	
	$("table").on("click",".update", function(){
		$("#Form").removeClass("New").addClass("Update");
		$("#title").text($.i18n.prop('ModifyChicken'));

		$("#FormDiv").show();
		
		$("#name").val($(this).attr('name'));
		$("#name").attr('chickenID', $(this).attr('id'));


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
	
	var url= "list/"+farmId;
	
	$.getJSON(url,
		
		function(data){
		fillTable(data);
		
		$('#titleTop').html($.i18n.prop('Farm')+": "+data.name);
		
		
		
	})
};

function fillTable (data){
	$("#results").empty();

	for(var index in data.chickenList){
		$("#results").append(
				$('<tr>')
				.append(
						$("<td>").append( data.chickenList[index].name )
						)
				.append(
						$("<td>").append( data.chickenList[index].eggList.length )
						)
				.append(
						$('<td>').append( "<a href=\"../Eggs/"+ data.chickenList[index].id +"?language="+lang+"\">"+$.i18n.prop('List')+" </a> ")
						)
				.append(
						$("<td>").append( "<button class=\"update\"  name=\""+data.chickenList[index].name+"\" id=\""+ data.chickenList[index].id +"\"> "+$.i18n.prop('Update')+" </button> ")
						)
				.append(
						$("<td>").append( "<button class=\"delete\" id=\""+ data.chickenList[index].id +"\"> "+$.i18n.prop('Delete')+" </button> ")
						))
	}
}
		

	