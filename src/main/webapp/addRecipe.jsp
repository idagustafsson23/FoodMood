<%@ include file="header.jsp"%>


<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<form action="http://localhost:8080/recipe/addRecipe" role="form"
				method="POST">
				<div class="form-group">
					<label for="recipeName">Recept namn:</label> <input type="text"
						class="form-control" id="recipeName" name="recipeName">
				</div>

				<div class="form-group">
					<label for="recipeIngridients" class="col-xs-2 control-label">Recept ingredienser:</label>
					<div class="col-xs-10">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" />
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" />
							</div>
							<div class="form-group">
								<select class="form-control" id="recipeIngridients">
									<option>dl</option>
									<option>l</option>
									<option>cl</option>
									<option>ml</option>
									<option>msk</option>
									<option>tsk</option>
									<option>krm</option>
									<option>g</option>
									<option>kg</option>

								</select>
							</div>
							<div class="form-group">
								<select class="form-control" id="recipeIngridients">
									<option>Taggar:</option>
									<option>Rött Kött</option>
									<option>Chark</option>
									<option>Fläsk Kött</option>
									<option>Fågel</option>
									<option>Blötdjur</option>
									<option>Fisk</option>
									<option>Skaldjur</option>
									<option>Mjukost och Grädde</option>
									<option>Mögelost</option>
									<option>Hård ost</option>
									<option>Lök</option>
									<option>Gröna grönsaker</option>
									<option>Rotfrukter och Squash</option>
									<option>Tomat, Aubergine och Paprika</option>
									<option>Svamp</option>
									<option>Nötter och Frön</option>
									<option>Bönor och Ärtor</option>
									<option>Svartpeppar</option>
									<option>Rödpeppar</option>
									<option>Hot & Spicy</option>
									<option>Örter</option>
									<option>Baknings kryddor</option>
									<option>Exotiska och Aromatiska kryddor</option>
									<option>Vita stärkelser</option>
									<option>Hela vetekorn</option>
									<option>Söta stärkelserika grönsaker</option>
									<option>Potatis</option>
									<option>Frukt och Bär</option>
									<option>Vanilj och Karamel</option>
									<option>Choklad och Kaffe</option>
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
						type="text" class="form-control" id="recipeComponentName">
				</div>
				<div class="form-group">
					<label for="recipeIngridients" class="col-xs-2 control-label">Tillbehör ingredienser:</label>
					<div class="col-xs-10">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Typ" />
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mängd" />
							</div>
							<div class="form-group">
								<select class="form-control" id="recipeIngridients">
									<option>dl</option>
									<option>l</option>
									<option>cl</option>
									<option>ml</option>
									<option>msk</option>
									<option>tsk</option>
									<option>krm</option>
									<option>g</option>
									<option>kg</option>

								</select>
							</div>
							<div class="form-group">
								<select class="form-control" id="recipeIngridients">
									<option>Taggar:</option>
									<option>Rött Kött</option>
									<option>Chark</option>
									<option>Fläsk Kött</option>
									<option>Fågel</option>
									<option>Blötdjur</option>
									<option>Fisk</option>
									<option>Skaldjur</option>
									<option>Mjukost och Grädde</option>
									<option>Mögelost</option>
									<option>Hård ost</option>
									<option>Lök</option>
									<option>Gröna grönsaker</option>
									<option>Rotfrukter och Squash</option>
									<option>Tomat, Aubergine och Paprika</option>
									<option>Svamp</option>
									<option>Nötter och Frön</option>
									<option>Bönor och Ärtor</option>
									<option>Svartpeppar</option>
									<option>Rödpeppar</option>
									<option>Hot & Spicy</option>
									<option>Örter</option>
									<option>Baknings kryddor</option>
									<option>Exotiska och Aromatiska kryddor</option>
									<option>Vita stärkelser</option>
									<option>Hela vetekorn</option>
									<option>Söta stärkelserika grönsaker</option>
									<option>Potatis</option>
									<option>Frukt och Bär</option>
									<option>Vanilj och Karamel</option>
									<option>Choklad och Kaffe</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="recipeComponentDescription">Tillbehör instruktioner:</label>
					<textarea class="form-control" rows="3"
						id="recipeComponentDescripton"></textarea>
				</div>
				
				<div class="form-group">
          			<button type="submit" class="btn btn-default">Submit</button>
          		</div>
				
			</form>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>