
var url = window.location.href.toString();
var parts = url.split("/");
var chickenId = parts[parts.length-1];
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

	$("table").hide();
	
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
		$("#title").text($.i18n.prop('NewEgg'));
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
		
		

	
	$("#name").blur(function(){
		
		isNameOk();
		});
	
	
	//UPDATE
	
	$("table").on("click",".update", function(){
		$("#Form").removeClass("New").addClass("Update");
		$("#title").text($.i18n.prop('ModifyEgg'));

		$("#FormDiv").show();
		
		$("#name").val($(this).attr('name'));
		$("#name").attr('eggID', $(this).attr('id'));


	});
	
});	
	
	
	function isNameOk(){
		
		var name = $("#name").val();
		
		if(name.length >15){
				
			$("#nameError").html($.i18n.prop('eColorLength'));
			$("#nameError").show();
			
			return false;
			}else{
		
		if ($.trim(name).length == 0) {
				  
				  $("#nameError").html($.i18n.prop('eColorNull'));
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
		var chickenUrl = contextPath+"/Chickens/"+data.farm.id+"?language="+lang;
		$('#return').attr("href",chickenUrl);
		
		if(data.eggList.length == 0){
			$("table").hide();

			$("#noInfo").html($.i18n.prop('eNoInfo'));
			$("#noInfo").show();
			
		}else{
			fillTable(data);
			$("table").show();
			$("#noInfo").hide();
			
			
		}
		
	
		
		
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
						$("<td>").append( "<button class=\"update\"  name=\""+data.eggList[index].color+"\" id=\""+ data.eggList[index].id +"\"> "+$.i18n.prop('Update')+" </button> ")
						)
				.append(
						$("<td>").append( "<button class=\"delete\" id=\""+ data.eggList[index].id +"\"> "+$.i18n.prop('Delete')+" </button> ")
						))
	}
}
		