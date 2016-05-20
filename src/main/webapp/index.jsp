<%@ include file ="header.jsp"%>

<div class="container">	
<div class="row">
	<div class="col-sm-12">
	
		<% if(request.getAttribute("message") != null) {%>
		<div class="form-group">
			<div class="col-sm-2"></div>
	    	<div class="col-sm-10">
	   		 <label> ${message}</label>
	    	</div>
			</div>
		<%}%>
	
		<h1>Välkommen!</h1>		
		<a href="addRecipe.jsp">Lägg till recept!</a><br>
		
		<a href="/recipe/getAllRecipes">Se alla recept</a><br>
		<%
		ArrayList<Recipe> allRecipes = (ArrayList<Recipe>) request.getAttribute("listOfRecipes");
		%>
		<% if (allRecipes.size() < 10) { 
				for(int i = 0; i < allRecipes.size(); i++ ){
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
			}else{
			Random random = new Random();
			ArrayList<Integer> randomIndex = new ArrayList<Integer>();
			randomIndex.add(random.nextInt(allRecipes.size()-1));
			for(int i = 0; i < 8; i++){
				int tempNumber = random.nextInt(allRecipes.size()-1);
				for(int a = 0; a < randomIndex.size(); a++){
					if(tempNumber == randomIndex.get(i)){
						tempNumber = random.nextInt(allRecipes.size()-1);
						a = -1;
					}
				}
				randomIndex.add(tempNumber);
			}
			
			for(int i = 0; i < randomIndex.size(); i++){
		%>
			<div class = "col-sm-4">
					<h1><a href="/recipe/getRecipe/ <%=allRecipes.get(randomIndex.get(i)).getId()%> "><%= allRecipes.get(randomIndex.get(i)).getRecipeName() %></a></h1>
					<a href="/recipe/getRecipe/ <%=allRecipes.get(randomIndex.get(i)).getId()%> "><div id="picture"><%
						byte[] rawPicture = allRecipes.get(randomIndex.get(i)).getPicture();
					String url = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(rawPicture);
					%> <img alt="FoodMood" src="<%=url%>"></div></a>
					</div>
		
		<%} }%>
		
		
		
	</div>
</div>

</div>

<%@ include file="footer.jsp" %>
