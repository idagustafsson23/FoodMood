<%@ include file ="header.jsp"%>

<div class="container">	
<div class="row">
	<div class="col-sm-12">
		<h1>V�lkommen!</h1>		
		<a href="addRecipe.jsp">L�gg till recept!</a><br>
		<a href="apitest.jsp">Testa api</a>
	</div>
</div>


<div class="row">
	<div class="col-md-4">	
	${recipename}
	</div>
</div>


</div>


<%@ include file="footer.jsp" %>