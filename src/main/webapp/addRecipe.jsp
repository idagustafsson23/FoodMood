<%@ include file="header.jsp"%>


<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<form action="http://localhost:8080/recipe/addRecipe" role="form"
				method="POST" id="recipeform">
				<div class="form-group">
					<label for="recipeName">Recept namn:</label> <input type="text"
						class="form-control" id="recipeName" name="recipeName">
				</div>
				
				<div class="form-group">
					<label for="recipeTag">Tillagningssätt:</label> 
					<select class="form-control" id="recipeTag" name="recipeTag">
						<option value="Grilled or Barbecued">Grillat</option>
						<option value="Sautéed or Fried">Brynt eller Stekt</option>
						<option value="Smoked">Rökt</option>
						<option value="Roasted">Rostat</option>
						<option value="Poached or Steamed">Kokt eller ångkokt</option>

					</select>
				</div>

				<div class="form-group">
					<label for="recipeIngridients" class="col-xs-2 control-label">Recept ingredienser:</label>
					<div class="col-xs-10">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" name="recipeIngredientName" id="recipeIngredientName"/>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" name="recipeIngredientAmount" id="recipeIngredientAmount"/>
							</div>
			   				<div class="form-group">
								<select class="form-control" id="recipeIngridients" name="recipeAmountUnit" id="recipeAmountUnit">
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
								<select class="form-control" id="recipeIngredientTags" name="recipeIngredientTags" id="recipeIngredientTags">
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
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="recipeDescription">Recept instruktioner:</label>
					<textarea class="form-control" rows="3" id="recipeDescripton" name="recipeDescription"></textarea>
				</div>
				<div class="form-group">
					<label for="recipeComponentName">Tillbehör namn:</label> <input
						type="text" class="form-control" id="recipeComponentName" name="recipeComponentName">
				</div>
				<div class="form-group">
					<label for="recipeComponentIngredient" class="col-xs-2 control-label">Tillbehör ingredienser:</label>
					<div class="col-xs-10">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" name="componentIngredientName"/>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" name="componentIngredientAmount" />
							</div>
							<div class="form-group">
								<select class="form-control" id="recipeIngridients" name="componentAmountUnit">
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
								<select class="form-control" id="recipeIngridients" name="componentIngredientTags">
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
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="recipeComponentDescription">Tillbehör instruktioner:</label>
					<textarea class="form-control" rows="3"
						id="recipeComponentDescripton" name="recipeComponentDescripton"></textarea>
				</div>
				
				<div class="form-group">
          			<button type="submit" class="btn btn-default">Lägg Till</button>
          			<button type="button" class="btn btn-default" id="btnadd">Lägg till fler recept</button>
          		</div>
				
			</form>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>