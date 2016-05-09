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
					<label for="recipeTag">Tillagningss�tt:</label> 
					<select class="form-control" id="recipeTag" name="recipeTag">
						<option value="Grilled or Barbecued">Grillat</option>
						<option value="Saut�ed or Fried">Brynt eller Stekt</option>
						<option value="Smoked">R�kt</option>
						<option value="Roasted">Rostat</option>
						<option value="Poached or Steamed">Kokt eller �ngkokt</option>

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
								<input type="text" class="form-control" placeholder="M�ngd" name="recipeIngredientAmount" id="recipeIngredientAmount"/>
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
									<option value="Red Meat">R�tt K�tt</option>
									<option value="Cured Meat">Chark</option>
									<option value="Pork">Fl�sk K�tt</option>
									<option value="Poultry">F�gel</option>
									<option value="Mollusk">Bl�tdjur</option>
									<option value="Fish">Fisk</option>
									<option value="Lobster and Shellfish">Skaldjur</option>
									<option value="Soft cheese and Cream">Mjukost och Gr�dde</option>
									<option value="Pungent cheese">M�gelost</option>
									<option value="Hard cheese">H�rd ost</option>
									<option value="Alliums">L�k</option>
									<option value="Green vegetables">Gr�na gr�nsaker</option>
									<option value="Root vegetables and Squash">Rotfrukter och Squash</option>
									<option value="Nightshades">Tomat, Aubergine och Paprika</option>
									<option value="Funghi">Svamp</option>
									<option value="Nuts and Seeds">N�tter och Fr�n</option>
									<option value="Beans and Peas">B�nor och �rtor</option>
									<option value="Black pepper">Svartpeppar</option>
									<option value="Red pepper">R�dpeppar</option>
									<option value="Hot and Spicy">Hot and Spicy</option>
									<option value="Herbs">�rter</option>
									<option value="Baking spices">Baknings kryddor</option>
									<option value="Exotic and Aromatic spices">Exotiska och Aromatiska kryddor</option>
									<option value="White starches">Vita st�rkelser</option>
									<option value="Whole wheat grains">Hela vetekorn</option>
									<option value="Sweet starchy vegetables">S�ta st�rkelserika gr�nsaker</option>
									<option value="Potato">Potatis</option>
									<option value="Fruit and Berries">Frukt och B�r</option>
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
					<label for="recipeComponentName">Tillbeh�r namn:</label> <input
						type="text" class="form-control" id="recipeComponentName" name="recipeComponentName">
				</div>
				<div class="form-group">
					<label for="recipeComponentIngredient" class="col-xs-2 control-label">Tillbeh�r ingredienser:</label>
					<div class="col-xs-10">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" name="componentIngredientName"/>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="M�ngd" name="componentIngredientAmount" />
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
									<option value="Red Meat">R�tt K�tt</option>
									<option value="Cured Meat">Chark</option>
									<option value="Pork">Fl�sk K�tt</option>
									<option value="Poultry">F�gel</option>
									<option value="Mollusk">Bl�tdjur</option>
									<option value="Fish">Fisk</option>
									<option value="Lobster and Shellfish">Skaldjur</option>
									<option value="Soft cheese and Cream">Mjukost och Gr�dde</option>
									<option value="Pungent cheese">M�gelost</option>
									<option value="Hard cheese">H�rd ost</option>
									<option value="Alliums">L�k</option>
									<option value="Green vegetables">Gr�na gr�nsaker</option>
									<option value="Root vegetables and Squash">Rotfrukter och Squash</option>
									<option value="Nightshades">Tomat, Aubergine och Paprika</option>
									<option value="Funghi">Svamp</option>
									<option value="Nuts and Seeds">N�tter och Fr�n</option>
									<option value="Beans and Peas">B�nor och �rtor</option>
									<option value="Black pepper">Svartpeppar</option>
									<option value="Red pepper">R�dpeppar</option>
									<option value="Hot and Spicy">Hot and Spicy</option>
									<option value="Herbs">�rter</option>
									<option value="Baking spices">Baknings kryddor</option>
									<option value="Exotic and Aromatic spices">Exotiska och Aromatiska kryddor</option>
									<option value="White starches">Vita st�rkelser</option>
									<option value="Whole wheat grains">Hela vetekorn</option>
									<option value="Sweet starchy vegetables">S�ta st�rkelserika gr�nsaker</option>
									<option value="Potato">Potatis</option>
									<option value="Fruit and Berries">Frukt och B�r</option>
									<option value="Vanilla and Caramel">Vanilj och Karamel</option>
									<option value="Chocolate and Coffee">Choklad och Kaffe</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="recipeComponentDescription">Tillbeh�r instruktioner:</label>
					<textarea class="form-control" rows="3"
						id="recipeComponentDescripton" name="recipeComponentDescripton"></textarea>
				</div>
				
				<div class="form-group">
          			<button type="submit" class="btn btn-default">L�gg Till</button>
          			<button type="button" class="btn btn-default" id="btnadd">L�gg till fler recept</button>
          		</div>
				
			</form>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>