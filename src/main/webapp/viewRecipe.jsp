<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<>h1>${recipe.recipeName}</h1>
				<br>
				<c:forEach var="listValue" items="${recipe.recipeDescription}">
					<>h4>${listValue}</h4><br>
				</c:forEach>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>