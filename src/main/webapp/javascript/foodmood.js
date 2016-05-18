var $recipe;
var $ingredients = [];
// jQuery begin 
$(document).ready(function() {
	
	$("#btnaddingredient").on('click', function() {
		addIngredient();
	});

	$("#btnaddrecipe").on('click', function() {
		addRecipe();
	});	
});



function addIngredient() {
	var $ingredientName = $("#recipeIngredientName").val();
	var $ingredientAmount = $("#recipeIngredientAmount").val();
	var $amountUnit = $("#recipeAmountUnit").val();
	var $ingredientTags = $("#recipeIngredientTags").val();
	
	$ingredient = {			
			IngredientName: $ingredientName,
			IngredientAmount : $ingredientAmount,
			AmountUnit : $amountUnit,
			IngredientTags : $ingredientTags			
	};
	
	$ingredients.push($ingredient);
	
	console.log($ingredients);
}


function addRecipe() {
	$recipeName = $("#recipeName").val();
	$recipeDescription = $("#recipeDescripton").val();
	$recipe = {
		recipename : $recipeName,
		recipedescription : $recipeDescription,
		ingridients : $ingredients
	};
	console.log($recipe);
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/recipe/addrecipe",
		data : JSON.stringify($recipe),
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