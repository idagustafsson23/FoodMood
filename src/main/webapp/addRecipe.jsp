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
  					<label for="recipeDescription">Recept information:</label>
  					<textarea class="form-control" rows="5" id="recipeDescripton"></textarea>
				</div>
			</form>
		</div>
	</div>
</div>


<%@ include file="footer.jsp" %>