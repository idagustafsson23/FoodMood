<%@ include file="header.jsp"%>
	<div class="container">	
<div class="row">
	<div class="col-sm-12">
		
		
		
	</div>
	<%
	ArrayList<Recipe> allRecipes = (ArrayList<Recipe>) request.getAttribute("listOfRecipes");

	
	
			for(int i = 0; i < allRecipes.size(); i++){	
			%>
				
				
 				 
  				  <div class="col-sm-3">
  				  		<h1><a href="/recipe/getRecipe/<%=allRecipes.get(i).getId()%> "><%= allRecipes.get(i).getRecipeName() %></a></h1>
						<a href="/recipe/getRecipe/ <%=allRecipes.get(i).getId()%> "><div id="picture"><%
						byte[] rawPicture = allRecipes.get(i).getPicture();
						String url = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(rawPicture);
						%> 
						<div class="img-thumbnail">
						<img src="<%=url%>" class="img-thumbnail" alt="FoodMood"></div></a>
						</div>
					
  				  
  				  
 				
 				
				
				</div>
				
				
			<%
			}
			%>
</div>
<br>
</div>
<%@ include file="footer.jsp"%>