// jQuery begin 
$(document).ready(function() {
	$("#btnadd").on('click', function() {
	   addMoreRecipes();
	   clearFields();
	});
	
});

function clearFields() {
	$("input[type=text]").val("");
    $("textarea").val("");
}

function addMoreRecipes() {
	//need to add every value from addrecipe form control and send to spring controller	
	
	var jsonvalues =
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/",
		data : JSON.stringify(jsonvalues),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("success: ", data);
			//display(data);
		},
		error : function(e) {
			console.log("error: ", e);
			//display(e);
		},
		done : function(e) {
			console.log("done");
		}
	});
}

function printRecipes() {
	
}