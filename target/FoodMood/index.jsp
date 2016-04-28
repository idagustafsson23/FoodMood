<%@ include file ="header.jsp"%>



<div class="container">
	
<div class="row">
	<div class="col-sm-12">

<form role="form" action="http://localhost:8080/recipe/regRecipe" method="POST">
  <div class="form-group">
    <label for="recipeName">Name of recipe:</label>
    <input type="text" class="form-control" id="recipeName" name="recipeName">
  </div>
  <div class="form-group">
    <label for="recipeDescription">Describe the recipe:</label>
    <input type="text" class="form-control" id="recipeDescription" name="recipeDescription">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>


	</div>
</div>






	
</div>

	


<%@ include file="footer.jsp" %>
