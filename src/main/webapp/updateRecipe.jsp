<%@ include file="header.jsp"%>

<% 
		Recipe recipe = (Recipe) request.getAttribute("recipe");
		ArrayList<String> recipeDescription = recipe.getRecipeDescription();
		List<Ingredient> recipeIngredients = recipe.getRecipeIngredients();
		List<RecipeComponent> recipeComponents = recipe.getRecipeComponents();
%>


<div class="container">
	<div class="row">
		<div class="col-sm-12">
		<!-- ta bort action för testning via jquery -->
			<form role="form" method="POST" id="recipeform" action="http://localhost:8080/recipe/saveUpdatedRecipe" enctype="multipart/form-data">
				<div class="form-group">
					<label for="recipeName">Receptnamn:</label> <input type="text"
						class="form-control" id="recipeName" name="recipeName" value="<%=recipe.getRecipeName()%>">
						
						<!-- uppdatera bildfil? -->
						
				</div>
				
				<div class="form-group">
					<label for="recipeTag">Tillagningssätt:</label> 
					<select class="form-control" id="recipeTag" name="recipeTag">
						<option value="Grilled or Barbecued">Grillat</option>
						<option value="Sautéed or Fried">Brynt eller Stekt</option>
						<option value="Smoked">Rökt</option>
						<option value="Roasted">Rostat</option>
						<option value="Poached or Steamed">Kokt eller ångkokt</option>
						<option value="other">Annat tillagningssätt</option>

					</select>
				</div>

				<div class="form-group">
					<label for="recipeIngridients">Recept-ingredienser:</label>
					<p id="addRecipeIngredientsLabel"></p>
					<%
					for(int i = 0; i < recipeIngredients.size(); i++) {%>
						<p><%=recipeIngredients.get(i).getIngredientName()%> <%=recipeIngredients.get(i).getAmountPerPortion()%> <%=recipeIngredients.get(i).getUnitOfMeasurement()%></p>
						<input type='hidden' name='recipeIngredientName<%=i+1%>' value='<%=recipeIngredients.get(i).getIngredientName()%>'>
						<input type='hidden' name='recipeIngredientAmount<%=i+1%>' value='<%=recipeIngredients.get(i).getAmountPerPortion()%>'>
						<input type='hidden' name='recipeIngredientAmountUnit<%=i+1%>' value='<%=recipeIngredients.get(i).getUnitOfMeasurement()%>'>
						<input type='hidden' name='recipeIngredientTag<%=i+1%>' value='<%=recipeIngredients.get(i).getFoodTag().getTagName()%>'>						
					<%}%>
					<div>
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" name="recipeIngredientName" id="recipeIngredientName"/>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" name="recipeIngredientAmount" id="recipeIngredientAmount"/>
							</div>
			   				<div class="form-group">
								<select class="form-control" name="recipeAmountUnit" id="recipeAmountUnit">
									<option value="dl">dl</option>
									<option value="l">l</option>
									<option value="cl">cl</option>
									<option value="ml">ml</option>
									<option value="msk">msk</option>
									<option value="tsk">tsk</option>
									<option value="krm">krm</option>
									<option value="g">g</option>
									<option value="kg">kg</option>
									<option value="st">st</option>

								</select>
							</div>
							<div class="form-group">
								<select class="form-control" name="recipeIngredientTag" id="recipeIngredientTag">
									<option value="null">Taggar:</option>
									<option value="Red Meat">Rött Kött</option>
									<option value="Cured Meat">Chark</option>
									<option value="Pork">Fläsk Kött</option>
									<option value="Poultry">Fågel</option>
									<option value="Mollusk">Blötdjur</option>
									<option value="Fish">Fisk</option>
									<option value="Lobster and Shellfish">Skaldjur</option>
									<option value="Soft cheese and Cream">Mjukost och Grädde</option>
									<option value="Pungent cheese">Mögelost</option>
									<option value="Hard cheese">Hård ost</option>
									<option value="Alliums">Lök</option>
									<option value="Green vegetables">Gröna grönsaker</option>
									<option value="Root vegetables and Squash">Rotfrukter och Squash</option>
									<option value="Nightshades">Tomat, Aubergine och Paprika</option>
									<option value="Funghi">Svamp</option>
									<option value="Nuts and Seeds">Nötter och Frön</option>
									<option value="Beans and Peas">Bönor och Ärtor</option>
									<option value="Black pepper">Svartpeppar</option>
									<option value="Red pepper">Rödpeppar</option>
									<option value="Hot and Spicy">Hot and Spicy</option>
									<option value="Herbs">Örter</option>
									<option value="Baking spices">Baknings kryddor</option>
									<option value="Exotic and Aromatic spices">Exotiska och Aromatiska kryddor</option>
									<option value="White starches">Vita stärkelser</option>
									<option value="Whole wheat grains">Hela vetekorn</option>
									<option value="Sweet starchy vegetables">Söta stärkelserika grönsaker</option>
									<option value="Potato">Potatis</option>
									<option value="Fruit and Berries">Frukt och Bär</option>
									<option value="Vanilla and Caramel">Vanilj och Karamel</option>
									<option value="Chocolate and Coffee">Choklad och Kaffe</option>
								</select>
							</div>
							<div>
							    <button type="button" class="btn btn-primary" id="btnAddRecipeIngredient">Lägg till</button>
							</div>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="recipeDescription">Recept instruktioner:</label>
					<textarea class="form-control" rows="3" id="recipeDescripton" name="recipeDescription">
					<%for(String currentString : recipeDescription) {%> 
						<%=currentString%>	
					<%}%>
					
					</textarea>
				</div>
			
				
				<div id="wrapAddComponent1" class="wrapAddComponent">
				<div class="form-group">
					<label for="recipeComponentName1">Tillbehör 1:</label> 
					<input type="text" class="form-control" id="recipeComponentName1" name="recipeComponentName1">
				</div>
				<div class="form-group">
					<label for="recipeComponentIngredient">Tillbehör 1 ingredienser:</label>
					<p id="addComponent1IngredientsLabel"></p>
					<div>
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" name="componentIngredientName1" id="componentIngredientName1"/>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" name="componentIngredientAmount1" id="componentIngredientAmount1" />
							</div>
							<div class="form-group">
								<select class="form-control" id="componentAmountUnit1" name="componentAmountUnit1">
									<option value="dl">dl</option>
									<option value="l">l</option>
									<option value="cl">cl</option>
									<option value="ml">ml</option>
									<option value="msk">msk</option>
									<option value="tsk">tsk</option>
									<option value="krm">krm</option>
									<option value="g">g</option>
									<option value="kg">kg</option>
									<option value="st">st</option>

								</select>
							</div>
							<div class="form-group">
								<select class="form-control" id="componentIngredientTag1" name="componentIngredientTag1">
									<option value="null">Taggar:</option>
									<option value="Red Meat">Rött Kött</option>
									<option value="Cured Meat">Chark</option>
									<option value="Pork">Fläsk Kött</option>
									<option value="Poultry">Fågel</option>
									<option value="Mollusk">Blötdjur</option>
									<option value="Fish">Fisk</option>
									<option value="Lobster and Shellfish">Skaldjur</option>
									<option value="Soft cheese and Cream">Mjukost och Grädde</option>
									<option value="Pungent cheese">Mögelost</option>
									<option value="Hard cheese">Hård ost</option>
									<option value="Alliums">Lök</option>
									<option value="Green vegetables">Gröna grönsaker</option>
									<option value="Root vegetables and Squash">Rotfrukter och Squash</option>
									<option value="Nightshades">Tomat, Aubergine och Paprika</option>
									<option value="Funghi">Svamp</option>
									<option value="Nuts and Seeds">Nötter och Frön</option>
									<option value="Beans and Peas">Bönor och Ärtor</option>
									<option value="Black pepper">Svartpeppar</option>
									<option value="Red pepper">Rödpeppar</option>
									<option value="Hot and Spicy">Hot and Spicy</option>
									<option value="Herbs">Örter</option>
									<option value="Baking spices">Baknings kryddor</option>
									<option value="Exotic and Aromatic spices">Exotiska och Aromatiska kryddor</option>
									<option value="White starches">Vita stärkelser</option>
									<option value="Whole wheat grains">Hela vetekorn</option>
									<option value="Sweet starchy vegetables">Söta stärkelserika grönsaker</option>
									<option value="Potato">Potatis</option>
									<option value="Fruit and Berries">Frukt och Bär</option>
									<option value="Vanilla and Caramel">Vanilj och Karamel</option>
									<option value="Chocolate and Coffee">Choklad och Kaffe</option>
								</select>
							</div>
						<div class="">
							<button type="button" class="btn btn-primary" id="btnAddComponentIngredient1">Lägg till</button>
						</div>

						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="recipeComponentDescription">Tillbehör 1 instruktioner:</label>
					<textarea class="form-control" rows="3"
						id="recipeComponentDescripton1" name="recipeComponentDescripton1"></textarea>
				</div>
				</div>
				
				
				
				<div id="wrapAddComponent2" class="wrapAddComponent">
				<div class="form-group">
					<label for="recipeComponentName2">Tillbehör 2:</label> 
					<input type="text" class="form-control" id="recipeComponentName2" name="recipeComponentName2">
				</div>
				<div class="form-group">
					<label for="recipeComponentIngredient2">Tillbehör 2 ingredienser:</label>
					<p id="addComponent2IngredientsLabel"></p>
					<div>
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" name="componentIngredientName2" id="componentIngredientName2"/>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" name="componentIngredientAmount2" id="componentIngredientAmount2" />
							</div>
							<div class="form-group">
								<select class="form-control" id="componentAmountUnit2" name="componentAmountUnit2">
									<option value="dl">dl</option>
									<option value="l">l</option>
									<option value="cl">cl</option>
									<option value="ml">ml</option>
									<option value="msk">msk</option>
									<option value="tsk">tsk</option>
									<option value="krm">krm</option>
									<option value="g">g</option>
									<option value="kg">kg</option>
									<option value="st">st</option>

								</select>
							</div>
							<div class="form-group">
								<select class="form-control" id="componentIngredientTag2" name="componentIngredientTag2">
									<option value="null">Taggar:</option>
									<option value="Red Meat">Rött Kött</option>
									<option value="Cured Meat">Chark</option>
									<option value="Pork">Fläsk Kött</option>
									<option value="Poultry">Fågel</option>
									<option value="Mollusk">Blötdjur</option>
									<option value="Fish">Fisk</option>
									<option value="Lobster and Shellfish">Skaldjur</option>
									<option value="Soft cheese and Cream">Mjukost och Grädde</option>
									<option value="Pungent cheese">Mögelost</option>
									<option value="Hard cheese">Hård ost</option>
									<option value="Alliums">Lök</option>
									<option value="Green vegetables">Gröna grönsaker</option>
									<option value="Root vegetables and Squash">Rotfrukter och Squash</option>
									<option value="Nightshades">Tomat, Aubergine och Paprika</option>
									<option value="Funghi">Svamp</option>
									<option value="Nuts and Seeds">Nötter och Frön</option>
									<option value="Beans and Peas">Bönor och Ärtor</option>
									<option value="Black pepper">Svartpeppar</option>
									<option value="Red pepper">Rödpeppar</option>
									<option value="Hot and Spicy">Hot and Spicy</option>
									<option value="Herbs">Örter</option>
									<option value="Baking spices">Baknings kryddor</option>
									<option value="Exotic and Aromatic spices">Exotiska och Aromatiska kryddor</option>
									<option value="White starches">Vita stärkelser</option>
									<option value="Whole wheat grains">Hela vetekorn</option>
									<option value="Sweet starchy vegetables">Söta stärkelserika grönsaker</option>
									<option value="Potato">Potatis</option>
									<option value="Fruit and Berries">Frukt och Bär</option>
									<option value="Vanilla and Caramel">Vanilj och Karamel</option>
									<option value="Chocolate and Coffee">Choklad och Kaffe</option>
								</select>
							</div>
						<div class="">
							<button type="button" class="btn btn-primary" id="btnAddComponentIngredient2">Lägg till</button>
						</div>

						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="recipeComponentDescription">Tillbehör 2 instruktioner:</label>
					<textarea class="form-control" rows="3"
						id="recipeComponentDescripton2" name="recipeComponentDescripton2"></textarea>
				</div>
				</div>
				
				
				
				<div id="wrapAddComponent3" class="wrapAddComponent">
				<div class="form-group">
					<label for="recipeComponentName3">Tillbehör 3:</label> 
					<input type="text" class="form-control" id="recipeComponentName3" name="recipeComponentName3">
				</div>
				<div class="form-group">
					<label for="recipeComponentIngredient3">Tillbehör 3 ingredienser:</label>
					<p id="addComponent3IngredientsLabel"></p>
					<div>
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" name="componentIngredientName3" id="componentIngredientName3"/>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" name="componentIngredientAmount3" id="componentIngredientAmount3" />
							</div>
							<div class="form-group">
								<select class="form-control" id="componentAmountUnit3" name="componentAmountUnit3">
									<option value="dl">dl</option>
									<option value="l">l</option>
									<option value="cl">cl</option>
									<option value="ml">ml</option>
									<option value="msk">msk</option>
									<option value="tsk">tsk</option>
									<option value="krm">krm</option>
									<option value="g">g</option>
									<option value="kg">kg</option>
									<option value="st">st</option>

								</select>
							</div>
							<div class="form-group">
								<select class="form-control" id="componentIngredientTag3" name="componentIngredientTag3">
									<option value="null">Taggar:</option>
									<option value="Red Meat">Rött Kött</option>
									<option value="Cured Meat">Chark</option>
									<option value="Pork">Fläsk Kött</option>
									<option value="Poultry">Fågel</option>
									<option value="Mollusk">Blötdjur</option>
									<option value="Fish">Fisk</option>
									<option value="Lobster and Shellfish">Skaldjur</option>
									<option value="Soft cheese and Cream">Mjukost och Grädde</option>
									<option value="Pungent cheese">Mögelost</option>
									<option value="Hard cheese">Hård ost</option>
									<option value="Alliums">Lök</option>
									<option value="Green vegetables">Gröna grönsaker</option>
									<option value="Root vegetables and Squash">Rotfrukter och Squash</option>
									<option value="Nightshades">Tomat, Aubergine och Paprika</option>
									<option value="Funghi">Svamp</option>
									<option value="Nuts and Seeds">Nötter och Frön</option>
									<option value="Beans and Peas">Bönor och Ärtor</option>
									<option value="Black pepper">Svartpeppar</option>
									<option value="Red pepper">Rödpeppar</option>
									<option value="Hot and Spicy">Hot and Spicy</option>
									<option value="Herbs">Örter</option>
									<option value="Baking spices">Baknings kryddor</option>
									<option value="Exotic and Aromatic spices">Exotiska och Aromatiska kryddor</option>
									<option value="White starches">Vita stärkelser</option>
									<option value="Whole wheat grains">Hela vetekorn</option>
									<option value="Sweet starchy vegetables">Söta stärkelserika grönsaker</option>
									<option value="Potato">Potatis</option>
									<option value="Fruit and Berries">Frukt och Bär</option>
									<option value="Vanilla and Caramel">Vanilj och Karamel</option>
									<option value="Chocolate and Coffee">Choklad och Kaffe</option>
								</select>
							</div>
						<div class="">
							<button type="button" class="btn btn-primary" id="btnAddComponentIngredient3">Lägg till</button>
						</div>

						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="recipeComponentDescription">Tillbehör 3 instruktioner:</label>
					<textarea class="form-control" rows="3"
						id="recipeComponentDescripton3" name="recipeComponentDescripton3"></textarea>
				</div>
				</div>
				
				

				
				
				<div>
          			<button type="button" class="btn btn-primary" id="btnAddComponent">Lägg till (fler) tillbehör</button>
          		</div>
          		
          		<div class="col-md-12 text-center">
          		<button type="submit" class="btn btn-primary text-center" id="btnAddRecipe">Spara recept!</button>
				</div>

				
			</form>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>