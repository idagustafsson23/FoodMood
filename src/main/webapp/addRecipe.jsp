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
    				<label for="recipeDescription">Recept instruktioner:</label>
    				<input type="textarea" class="form-control" id="recipeDescription">
  				</div>
			</form>
		</div>
	</div>
</div>


<%@ include file="footer.jsp" %>