<%@ include file ="header.jsp"%>


<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<form action="http://localhost:8080/recipe/addRecipe" role="form" method="POST" >
				<div class="form-group">
    				<label for="recipeName">Recept namn:</label>
    				<input type="text" class="form-control" id="recipeName">
  				</div>
  				<div class="form-group">
  					<label for="recipeIngridients">Recept ingredienser:</label>
  					<textarea class="form-control" rows="5" id="recipeIngridients"></textarea>
				</div>
  				<div class="form-group">
  					<label for="recipeDescription">Recept information:</label>
  					<textarea class="form-control" rows="5" id="recipeDescripton"></textarea>
				</div>
				<div class="form-group">
    				<label for="recipeComponentName">Tillbeh�r namn:</label>
    				<input type="text" class="form-control" id="recipeComponentName">
  				</div>
  				<div class="form-group">
  					<label for="recipeComponentIngridients">Tillbeh�r ingredienser:</label>
  					<textarea class="form-control" rows="5" id="recipeComponentIngridients"></textarea>
				</div>
  				<div class="form-group">
  					<label for="recipeComponentDescription">Tillbeh�r information:</label>
  					<textarea class="form-control" rows="5" id="recipeComponentDescripton"></textarea>
				</div>
			</form>
		</div>
	</div>
</div>


<%@ include file="footer.jsp" %>