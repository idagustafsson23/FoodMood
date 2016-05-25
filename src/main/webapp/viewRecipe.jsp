<%@ include file="header.jsp"%>
	<div class="container">
	
	
<% 
				Recipe recipe = (Recipe) request.getAttribute("recipe");
				ArrayList<String> recipeDescription = recipe.getRecipeDescription();
				List<Ingredient> recipeIngredients = recipe.getRecipeIngredients();
				List<RecipeComponent> recipeComponents = recipe.getRecipeComponents();
%>
	
		
	<div class="row">
		<div class="col-sm-12 wrapAddComponent">
		<div class="col-sm-6" >
			<div class="text-center"><h1><strong>${recipe.recipeName}</strong></h1></div>
			<br>
				<h3><strong>Ingredienser:</strong></h3>
			<%for(int i = 0; i < recipeIngredients.size(); i++){%>
					<h4><%= recipeIngredients.get(i).getIngredientName() %>
					<%= recipeIngredients.get(i).getAmountPerPortion() %>
					<%= recipeIngredients.get(i).getUnitOfMeasurement() %>
					</h4>
			<%}%>
			
				<h3><strong>Instruktioner:</strong></h3>
			<%for(int i = 0; i < recipeDescription.size(); i++){%>
				<h4><%= recipeDescription.get(i) %></h4>
			<%}%>
	
	
			<%for (int i = 0; i < recipeComponents.size(); i++){%>
				<div class="wrapAddComponent">
				<%List<Ingredient> recipeComponentIngredients = recipeComponents.get(i).getComponentIngredients();
				ArrayList<String> recipeComponentDescription = recipeComponents.get(i).getComponentDescription();
				%>

				<div class="text-center"><h3><strong><%=recipeComponents.get(i).getComponentName()%></strong></h3></div>
					<h4><strong>Ingredienser:</strong></h4>
				<%for(int p = 0; p < recipeComponentIngredients.size(); p++){%>
						<h5><%= recipeComponentIngredients.get(p).getIngredientName() %>
						<%= recipeComponentIngredients.get(p).getAmountPerPortion() %>
						<%= recipeComponentIngredients.get(p).getUnitOfMeasurement() %>
						</h5>
				<%}%>
					<h4><strong>Instruktioner:</strong></h4>
				<%for(int d = 0; d < recipeComponentDescription.size(); d++){%>
					<h5><%= recipeComponentDescription.get(d) %></h5>
				<%}%>
				</div>
			<%}%>
		</div>
		
		<div class="col-sm-6">
			<br>
			<div class="img-thumbnail" id="picture">
			<%byte[] rawPicture = recipe.getPicture();
				String url = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(rawPicture);
				%>
				<img src="<%=url%>" class="img-thumbnail" alt="FoodMood"></div>
			</div>			
			
		</div>
		</div>

					
		<div class="row">
			<div class="col-sm-6">
				<form action="http://localhost:8080/wine/getWine" role="form"
				method="POST" id="wineform">
					<div class="form-group">
						<label for="winePrice">Vin pris:</label>
						<select class="form-control" id="winePrice" name="winePrice">
							<option value="0-99">under 100 kr</option>
							<option value="100-300">100 - 300 kr</option>
							<option value="301-500">301 - 500 kr</option>
							<option value="501-5000">över 500 kr</option>
						</select>
					</div>
					<div class="form-group">
						<label for="mood">Humör:</label>
						<select class="form-control" id="mood" name="mood">
							<option value="flirty">Flörtig</option>
							<option value="happy">Glad</option>
							<option value="party">Festlig</option>
							<option value="sad">Ledsen</option>
							<option value="angry">Arg</option>
						</select>
					</div>
					<div class="form-group">
						<input type="hidden" name="recipeId" id="recipeId" value="<%=recipe.getId()%>">
						<button type="submit" class="btn btn-default" id="btnsearchwine">sök viner</button>
					</div>
					
				</form>
			</div>
			<div class=col-sm-6>
			<br>
			<%if(loggedIn) {
				if(userLoggedIn.isAdmin()) {%>
			<div class="pull-right">
				<a href="/recipe/updateRecipe/<%=recipe.getId()%>" class="btn btn-primary" role="button">Edit Recipe</a>
				<a href="/recipe/removeRecipe/<%=recipe.getId()%>" class="btn btn-warning" role="button">Delete Recipe</a>
			</div>
					<%} 
				}%>
			</div>
			
		</div>
		
	</div>
<%@ include file="footer.jsp"%>