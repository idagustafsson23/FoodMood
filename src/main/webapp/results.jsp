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
		
	</div>
	
	
	<div class="row">
		<%! int listSize = 3; %>
		
		<%		
			String druvsort = (String) request.getAttribute("grape");
			ArrayList<ApiWine> apiWines = (ArrayList<ApiWine>) request.getAttribute("apiWines");
			if(apiWines.size() < 3) {
				listSize = apiWines.size();
			}
			
		if(apiWines.size() == 0) {%>
			<h3>Tyvärr hittade vi inga matchande vin att köpa, vi tror att ett vin med druvsorten <strong><%=druvsort%></strong> skulle passa till denna måltid</h3>
		<% }else {%>
			<h3>Vi har matchat din måltid med följande vin (innehållande druvsorten <strong><%=druvsort%></strong>) som finns att köpa på Systembolaget</h3>
			<br>
		<%}	
		for (int i = 0; i < listSize && listSize > 0; i++) {
		%>
		<div class="col-sm-3 wrapAddComponent">
			<h1><%= apiWines.get(i).getName() %></h1>
			<h3>Pris: <%= apiWines.get(i).getPrice() %></h3>
			<h4><a href="<%=apiWines.get(i).getUrl()%>">Mer info</a></h4>
		</div>
		<div class="col-sm-1"></div>
		<%}%>
		
	</div>
</div>
<%@ include file="footer.jsp"%>