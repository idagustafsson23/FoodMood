var recipeIngredientstore = [];
var componentIngredientStore = [];
var componentStore = [];
var componentIngredient;
var added = false;

// jQuery begin 
$(document).ready(function() {
	//do same class call here to fix cleaner code for event calls
	$("#btnaddingredient").on('click', function() {
		addRecipeIngredient();
	   //clearRecipeIngredientsFields();
		
	});
	$("#btnaddcomponentingredient").on('click', function() {
		addComponentIngredient();				
		//clearComponentIngredientsFields();
	});
	$("#btnaddcomponents").on('click', function() {
		addComponent();
	
		//clearComponentFields()
	});
	$("#btnaddrecipe").on('click', function() {
		//addRecipeIngredient();
		//addComponentIngredient();
		//addComponent();
		addRecipe();
	});	
});

function clearComponentIngredientsFields() {
	
}

function addRecipeIngredient() {
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

	
	console.log(recipeIngredientstore);
}


function addComponentIngredient() {
	var $componentName = $("#recipeComponentName").val();
	var $ingredientName = $("#componentIngredientName").val();
	var $ingredientAmount = $("#componentIngredientAmount").val();
	var $amountUnit = $("#componentAmountUnit").val();
	var $ingredientTags = $("#componentIngredientTags").val();
	
	componentIngredient = {			
			componentIngredientName: $ingredientName,
			componentIngredientAmount : $ingredientAmount,
			componentAmountUnit : $amountUnit,
			componentIngredientTags : $ingredientTags			
	};
	
	componentIngredientStore.push(componentIngredient);
	
	console.log(componentIngredientStore);
}

function updateList(currentArray, values) {
	for (var j = 0; j < currentArray.length; j++) {
		currentArray[j] = values;
	}
}

function addComponent() {

	var $componentName = $("#recipeComponentName").val();
	var $componentDescription = $("#recipeComponentDescripton").val();
	
	
	var component = {
			recipeComponentName : $componentName,
			recipeComponentDescription : $componentDescription,
			componentIngredients : componentIngredientStore
	};	
		
	componentStore.push(component);		
	
	//update componentIngredientStore list with new values either from 0 or from last indexed position
	updateList(componentIngredientStore, componentIngredient);
	
	console.log(componentStore);
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
		url : "/recipe/addmorerecipes",
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