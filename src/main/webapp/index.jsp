<%@ include file ="header.jsp"%>

<div class="container">	
<div class="row">
	<div class="col-sm-12">
		<h1>V�lkommen! ${test}</h1>		
		<c:out value="${'test'}"/>
		<a href="addRecipe.jsp">L�gg till recept!</a><br>
		<a href="apitest.jsp">Testa api</a>
	</div>
</div>

</div>

	


<%@ include file="footer.jsp" %>
