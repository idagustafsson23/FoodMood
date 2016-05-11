<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<form action="http://localhost:8080/mood/addMood" role="form"
				method="POST">
					<div class="form-group">
						<label for="mood">Humör:</label> 
						<input type="text" class="form-control" id="mood" name="mood">
					</div>
					<div class="form-group">
						<label for="numberOfGrapes">Antal druvsorter:</label> <input type="text"
							class="form-control" id="numberOfGrapes" name="numberOfGrapes">
					</div>
				
					<div class="form-group">
						<label for="grape1">Druvsort 1:</label> <input type="text"
							class="form-control" id="grape1" name="grape1">
					</div>
					<div class="form-group">
						<label for="grape2">Druvsort 2:</label> <input type="text"
							class="form-control" id="grape2" name="grape2">
					</div>
					<div class="form-group">
						<label for="grape3">Druvsort 3:</label> <input type="text"
							class="form-control" id="grape3" name="grape3">
					</div>
					<div class="form-group">
						<label for="grape4">Druvsort 4:</label> <input type="text"
							class="form-control" id="grape4" name="grape4">
					</div>
					<div class="form-group">
						<label for="grape5">Druvsort 5:</label> <input type="text"
							class="form-control" id="grape5" name="grape5">
					</div>
					<div class="form-group">
						<label for="grape6">Druvsort 6:</label> <input type="text"
							class="form-control" id="grape6" name="grape6">
					</div>
					<div class="form-group">
						<label for="grape7">Druvsort 7:</label> <input type="text"
							class="form-control" id="grape7" name="grape7">
					</div>
					<div class="form-group">
						<label for="grape8">Druvsort 8:</label> <input type="text"
							class="form-control" id="grape8" name="grape8">
					</div>
					<div class="form-group">
						<label for="grape9">Druvsort 9:</label> <input type="text"
							class="form-control" id="grape9" name="grape9">
					</div>
					<div class="form-group">
						<label for="grape10">Druvsort 10:</label> <input type="text"
							class="form-control" id="grape10" name="grape10">
					</div>
					<div class="form-group">
						<label for="grape11">Druvsort 11:</label> <input type="text"
							class="form-control" id="grape11" name="grape11">
					</div>
					<div class="form-group">
						<label for="grape12">Druvsort 12:</label> <input type="text"
							class="form-control" id="grape12" name="grape12">
					</div>
					<div class="form-group">
						<label for="grape13">Druvsort 13:</label> <input type="text"
							class="form-control" id="grape13" name="grape13">
					</div>
					<div class="form-group">
						<label for="grape14">Druvsort 14:</label> <input type="text"
							class="form-control" id="grape14" name="grape14">
					</div>
					<div class="form-group">
          				<button type="submit" class="btn btn-default">Submit</button>
          			</div>
				</form>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>