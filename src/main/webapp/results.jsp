<%@ include file="header.jsp"%>
<div class="container">
	<%
		Recipe recipe = (Recipe) request.getAttribute("recipe");
		ArrayList<String> recipeDescription = recipe.getRecipeDescription();
		List<Ingredient> recipeIngredients = recipe.getRecipeIngredients();
		List<RecipeComponent> recipeComponents = recipe.getRecipeComponents();
	%>


	<div class="row">
		<div class="col-sm-6">
			<h1>${recipe.recipeName}</h1>
			<br>

			<%
				for (int i = 0; i < recipeIngredients.size(); i++) {
			%>
			<%=recipeIngredients.get(i).getIngredientName()%>
			<%=recipeIngredients.get(i).getAmountPerPortion()%>
			<%=recipeIngredients.get(i).getUnitOfMeasurement()%>
			<br>
			<%
				}
			%>


			<%
				for (int i = 0; i < recipeDescription.size(); i++) {
			%>
			<h5><%=recipeDescription.get(i)%></h5>
			<%
				}
			%>


			<%
				for (int i = 0; i < recipeComponents.size(); i++) {
					List<Ingredient> recipeComponentIngredients = recipeComponents.get(i).getComponentIngredients();
					ArrayList<String> recipeComponentDescription = recipeComponents.get(i).getComponentDescription();
			%>

			<h3><%=recipeComponents.get(i).getComponentName()%></h3>
			<%
				for (int p = 0; p < recipeComponentIngredients.size(); p++) {
			%>
			<%=recipeComponentIngredients.get(p).getIngredientName()%>
			<%=recipeComponentIngredients.get(p).getAmountPerPortion()%>
			<%=recipeComponentIngredients.get(p).getUnitOfMeasurement()%>
			<br>
			<%
				}
			%>

			<%
				for (int d = 0; d < recipeComponentDescription.size(); d++) {
			%>
			<h5><%=recipeComponentDescription.get(d)%></h5>
			<%
				}
			%>
			<%
				}
			%>
		</div>

		<div class="col-sm-6">
			<br>
			<div class="" id="picture">
				<%
					byte[] rawPicture = recipe.getPicture();
					String url = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(rawPicture);
				%><img alt="FoodMood" src="<%=url%>">
			</div>
		</div>
		<br>
		<%
			if (loggedIn) {
				if (userLoggedIn.isAdmin()) {
		%>
		<div class="pull-right">
			<a href="/recipe/updateRecipe/<%=recipe.getId()%>"
				class="btn btn-primary" role="button">Edit Recipe</a> <a
				href="/recipe/removeRecipe/<%=recipe.getId()%>"
				class="btn btn-warning" role="button">Delete Recipe</a>
		</div>
		<%
			}
			}
		%>
	</div>
	<div class="row">
		<%
			ArrayList<ApiWine> apiWines = (ArrayList<ApiWine>) request.getAttribute("apiWines");
			for (ApiWine wine : apiWines) {
		%>
		<div class="col-sm-4">
			<h1><%= wine.getName() %></h1>
			<h4>Druva: <%= wine.getGrape() %></h4>
			<h3>Pris: <%= wine.getPrice() %></h3>
			<h4><a href="<%=wine.getUrl()%>">Länk till Systembolaget!</a></h4>
		</div>
		<%
			}
		%>
	</div>
</div>
<%@ include file="footer.jsp"%>