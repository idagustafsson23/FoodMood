<%@ include file="header.jsp"%>


	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				
				<h1>${recipe.recipeName}</h1>
				<br>
				<% 
				Recipe recipe = (Recipe) request.getAttribute("recipe");
				ArrayList<String> recipeDescription = recipe.getRecipeDescription();
				for(int i = 0; i < recipeDescription.size(); i++){
				%>
					<h5><%= recipeDescription.get(i) %></h5>
				<%} %>
			</div>
		</div>
	</div>


<%@ include file="footer.jsp"%>