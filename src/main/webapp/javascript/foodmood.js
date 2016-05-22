

var recipeIngredientCount = 0;
var component1IngredientCount = 0;
var component2IngredientCount = 0;
var component3IngredientCount = 0;

var showComponent1 = false;
var showComponent2 = false;
var showComponent3 = false;

 
$(document).ready(function() {
	
	$('#wrapAddComponent1').hide();
	$('#wrapAddComponent2').hide();
	$('#wrapAddComponent3').hide();
	
	
	$("#btnAddRecipeIngredient").on('click', function() {
		addRecipeIngredient();
	});
	
	
	$("#btnAddComponent").on('click', function() {
		addComponent();
	});
	
	
	$("#btnAddComponentIngredient1").on('click', function() {
		addComponentIngredient1();
	});
	
	
	$("#btnAddComponentIngredient2").on('click', function() {
		addComponentIngredient2();
	});
	
	
	$("#btnAddComponentIngredient3").on('click', function() {
		addComponentIngredient3();
	});
	
	
	
	

});






function addRecipeIngredient() {
	
	recipeIngredientCount++;
	
	var $ingredientName = $("#recipeIngredientName").val();
	var $ingredientAmount = $("#recipeIngredientAmount").val();
	var $amountUnit = $("#recipeAmountUnit").val();
	var $ingredientTag = $("#recipeIngredientTag").val();
	
	var $txt = $("<p></p>").text($ingredientName + " " + $ingredientAmount + " " + $amountUnit);   
	var $hiddenName = "<input type='hidden' name='recipeIngredientName" + recipeIngredientCount + "' value='" + $ingredientName + "'>";
	var $hiddenAmount = "<input type='hidden' name='recipeIngredientAmount" + recipeIngredientCount + "' value='" + $ingredientAmount + "'>";
	var $hiddenAmountUnit = "<input type='hidden' name='recipeIngredientAmountUnit" + recipeIngredientCount + "' value='" + $amountUnit + "'>";
	var $hiddenIngredientTag = "<input type='hidden' name='recipeIngredientTag" + recipeIngredientCount + "' value='" + $ingredientTag + "'>";
	
	$("#addRecipeIngredientsLabel").after($txt);
	$("#addRecipeIngredientsLabel").after($hiddenName);
	$("#addRecipeIngredientsLabel").after($hiddenAmount);
	$("#addRecipeIngredientsLabel").after($hiddenAmountUnit);
	$("#addRecipeIngredientsLabel").after($hiddenIngredientTag);
	
	$("#recipeIngredientName").val('');
	$("#recipeIngredientAmount").val('');
	$("#recipeAmountUnit").val('');
	$("#recipeIngredientTag").val('');
	
}





function addComponent() {

	if(showComponent1 === false) {
		$('#wrapAddComponent1').show();
		showComponent1 = true;
	}else if(showComponent2 === false) {
		$('#wrapAddComponent2').show();
		showComponent2 = true;
	}else if(showComponent3 === false) {
		$('#wrapAddComponent3').show();
		showComponent3 = true;
	}else {
		$('#btnAddComponent').prop('disabled', true);
	}

}





function addComponentIngredient1() {
	
	component1IngredientCount++;
	
	var $componentIngredientName = $("#componentIngredientName1").val();
	var $componentIngredientAmount = $("#componentIngredientAmount1").val();
	var $componentAmountUnit = $("#componentAmountUnit1").val();
	var $componentIngredientTag = $("#componentIngredientTag1").val();
	
	var $txt = $("<p></p>").text($componentIngredientName + " " + $componentIngredientAmount + " " + $componentAmountUnit);   
	var $hiddenName = "<input type='hidden' name='component1IngredientName" + component1IngredientCount + "' value='" + $componentIngredientName + "'>";
	var $hiddenAmount = "<input type='hidden' name='component1IngredientAmount" + component1IngredientCount + "' value='" + $componentIngredientAmount + "'>";
	var $hiddenAmountUnit = "<input type='hidden' name='component1IngredientAmountUnit" + component1IngredientCount + "' value='" + $componentAmountUnit + "'>";
	var $hiddenIngredientTag = "<input type='hidden' name='component1IngredientTag" + component1IngredientCount + "' value='" + $componentIngredientTag + "'>";
	
	$("#addComponent1IngredientsLabel").after($txt);
	$("#addComponent1IngredientsLabel").after($hiddenName);
	$("#addComponent1IngredientsLabel").after($hiddenAmount);
	$("#addComponent1IngredientsLabel").after($hiddenAmountUnit);
	$("#addComponent1IngredientsLabel").after($hiddenIngredientTag);
	
	$("#componentIngredientName1").val('');
	$("#componentIngredientAmount1").val('');
	$("#componentAmountUnit1").val('');
	$("#componentIngredientTag1").val('');
	
}



function addComponentIngredient2() {
	
	component2IngredientCount++;
	
	var $componentIngredientName = $("#componentIngredientName2").val();
	var $componentIngredientAmount = $("#componentIngredientAmount2").val();
	var $componentAmountUnit = $("#componentAmountUnit2").val();
	var $componentIngredientTag = $("#componentIngredientTag2").val();
	
	var $txt = $("<p></p>").text($componentIngredientName + " " + $componentIngredientAmount + " " + $componentAmountUnit);   
	var $hiddenName = "<input type='hidden' name='component2IngredientName" + component1IngredientCount + "' value='" + $componentIngredientName + "'>";
	var $hiddenAmount = "<input type='hidden' name='component2IngredientAmount" + component1IngredientCount + "' value='" + $componentIngredientAmount + "'>";
	var $hiddenAmountUnit = "<input type='hidden' name='component2IngredientAmountUnit" + component1IngredientCount + "' value='" + $componentAmountUnit + "'>";
	var $hiddenIngredientTag = "<input type='hidden' name='component2IngredientTag" + component1IngredientCount + "' value='" + $componentIngredientTag + "'>";
	
	$("#addComponent2IngredientsLabel").after($txt);
	$("#addComponent2IngredientsLabel").after($hiddenName);
	$("#addComponent2IngredientsLabel").after($hiddenAmount);
	$("#addComponent2IngredientsLabel").after($hiddenAmountUnit);
	$("#addComponent2IngredientsLabel").after($hiddenIngredientTag);
	
	$("#componentIngredientName2").val('');
	$("#componentIngredientAmount2").val('');
	$("#componentAmountUnit2").val('');
	$("#componentIngredientTag2").val('');
	
}



function addComponentIngredient3() {
	
	component3IngredientCount++;
	
	var $componentIngredientName = $("#componentIngredientName3").val();
	var $componentIngredientAmount = $("#componentIngredientAmount3").val();
	var $componentAmountUnit = $("#componentAmountUnit3").val();
	var $componentIngredientTag = $("#componentIngredientTag3").val();
	
	var $txt = $("<p></p>").text($componentIngredientName + " " + $componentIngredientAmount + " " + $componentAmountUnit);   
	var $hiddenName = "<input type='hidden' name='component3IngredientName" + component1IngredientCount + "' value='" + $componentIngredientName + "'>";
	var $hiddenAmount = "<input type='hidden' name='component3IngredientAmount" + component1IngredientCount + "' value='" + $componentIngredientAmount + "'>";
	var $hiddenAmountUnit = "<input type='hidden' name='component3IngredientAmountUnit" + component1IngredientCount + "' value='" + $componentAmountUnit + "'>";
	var $hiddenIngredientTag = "<input type='hidden' name='component3IngredientTag" + component1IngredientCount + "' value='" + $componentIngredientTag + "'>";
	
	$("#addComponent3IngredientsLabel").after($txt);
	$("#addComponent3IngredientsLabel").after($hiddenName);
	$("#addComponent3IngredientsLabel").after($hiddenAmount);
	$("#addComponent3IngredientsLabel").after($hiddenAmountUnit);
	$("#addComponent3IngredientsLabel").after($hiddenIngredientTag);
	
	$("#componentIngredientName3").val('');
	$("#componentIngredientAmount3").val('');
	$("#componentAmountUnit3").val('');
	$("#componentIngredientTag3").val('');
	
}

