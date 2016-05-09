var recipeIngredientstore = [];
var componentIngredientStore = [];
var componentStore = [];

// jQuery begin 
$(document).ready(function() {
	$("#btnaddingredient").on('click', function() {
		addRecipeIngredient();
	   //clearRecipeIngredientsFields();
	   console.log(recipeIngredientstore);
	});
	$("#btnaddcomponentingredient").on('click', function() {
		addComponentIngredient();
		//clearComponentIngredientsFields();
	   console.log(componentIngredientStore);
	});
	$("#btnaddcomponents").on('click', function() {
		addComponentIngredient();
		addComponent();
		//clearComponentFields();
	   console.log(componentStore);

	});
	$("#btnaddrecipe").on('click', function() {
		addRecipeIngredient();
		addComponentIngredient();
		addComponent();
		addRecipe();
		

	});
	
});

function clearRecipeIngredientsField() {
	
}

function clearFields() {

}



function addRecipeIngredient() {
	//need to add every value from addrecipe form control and send to spring controller	
	var $ingredientName = $("#recipeIngredientName").val();
	var $ingredientAmount = $("#recipeIngredientAmount").val();
	var $amountUnit = $("#recipeAmountUnit").val();
	var $ingredientTags = $("#recipeIngredientTags").val();
	
	var recipeIngredient = {
			recipeIngredientName: $ingredientName,
			recipeIngredientAmount : $ingredientAmount,
			recipeAmountUnit : $amountUnit,
			recipeIngredientTags : $ingredientTags
	};
	
	
	recipeIngredientstore.push(recipeIngredient);
		
}

function addComponentIngredient() {
	//need to add every value from addrecipe form control and send to spring controller	
	var $ingredientName = $("#componentIngredientName").val();
	var $ingredientAmount = $("#componentIngredientAmount").val();
	var $amountUnit = $("#componentAmountUnit").val();
	var $ingredientTags = $("#componentIngredientTags").val();
	
	var componentIngredient = {
			componentIngredientName: $ingredientName,
			componentIngredientAmount : $ingredientAmount,
			componentAmountUnit : $amountUnit,
			componentIngredientTags : $ingredientTags
	};
	
	
	componentIngredientStore.push(componentIngredient);
		
}

function addComponent() {
	//need to add every value from addrecipe form control and send to spring controller	
	var $componentName = $("#recipeComponentName").val();
	var $componentDescription = $("#recipeComponentDescripton").val();
	
	var component = {
			recipeComponentName : $componentName,
			recipeComponentDescription : $componentDescription,
			componentIngredients : componentIngredientStore
	};
	
	
	componentStore.push(component);
		
}

function addRecipe() {
	var $name = $("#recipeName").val();
	var $description = $("#recipeDescripton").val();
	var $tag = $("#recipeTag").val();
	
	var $recipe = {
			recipeName : $name,
			recipeDescription : $description,
			recipeTag : $tag,
			recipeIngredints : recipeIngredientstore,
			recipeComponents : componentStore
	};
	
	console.log($recipe);
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/",
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