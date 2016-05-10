<%@ include file="header.jsp"%>
	<div class="container">	
<div class="row">
	<div class="col-sm-12">
		
		
		
	</div>
	<%
	ArrayList<Recipe> allRecipes = (ArrayList<Recipe>) request.getAttribute("listOfRecipes");

	
	
	%>
	<%
			for(int i = 0; i < allRecipes.size(); i++){	
			%>
				<div class = "col-sm-4">
					<h1><a href="/recipe/getRecipe/ <%=allRecipes.get(i).getId()%> "><%= allRecipes.get(i).getRecipeName() %></a></h1>
				</div>
				
				
			<%
			}
			%>
</div>

</div>
<%@ include file="footer.jsp"%>