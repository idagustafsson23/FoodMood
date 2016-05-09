
document.getElementById("add").onclick = function() {
    
    var recipeIngredientName = document.getElementById("recipeIngredientName").value; 
    var recipeIngredientAmount = document.getElementById("recipeIngredientAmount").value; 
    var recipeAmountUnit = document.getElementById("recipeAmountUnit").value;  
    var recipeIngredientTags = document.getElementById("recipeIngredientTags").value;
    
    //Now construct a quick list element
    var li = "<li>" + recipeIngredientName + "</li>";

    //Now use appendChild and add it to the list!
    document.getElementById("list").appendChild(li);
}