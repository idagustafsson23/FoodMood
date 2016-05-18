<%@ include file="header.jsp"%>
	<div class="container">	
<div class="row">
	<div class="col-sm-12">
		
		
		
	</div>
	<%
	ArrayList<Recipe> allRecipes = (ArrayList<Recipe>) request.getAttribute("listOfRecipes");

	
	
			for(int i = 0; i < allRecipes.size(); i++){	
			%>
				<div class = "col-sm-4">
					<h1><a href="/recipe/getRecipe/ <%=allRecipes.get(i).getId()%> "><%= allRecipes.get(i).getRecipeName() %></a></h1>
					<a href="/recipe/getRecipe/ <%=allRecipes.get(i).getId()%> "><div id="picture"><%
						byte[] rawPicture = allRecipes.get(i).getPicture();
					String url = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(rawPicture);
					%> <img alt="FoodMood" src="<%=url%>"></div></a>
				</div>
				
				
			<%
			}
			%>
</div>

</div>
<%@ include file="footer.jsp"%>