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
	
	<% if(request.getAttribute("userLoggedIn") != null) {%>
<form class="form-horizontal" role="form" method="POST" action="/user/updateUser/<%=userLoggedIn.getId()%>">
	
  <div class="form-group">  
  	<div class="col-sm-2"></div>
    <div class="col-sm-10">
    <label>Uppdatera din Little Broonie avatar här om du vill...</label>
    </div>
  </div>
  <div class="form-group">  
    <label class="control-label col-sm-2" for="registerUsername">Användarnamn:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerUsername" name="username" value="${userLoggedIn.username}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="registerPassword">Lösenord:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="registerPassword" name="password" value="${userLoggedIn.password}">
    </div>
  </div>
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerName">Namn:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerName" name="name" value="${userLoggedIn.name}">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerEmail">Email:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="registerEmail" name="email" value="${userLoggedIn.email}">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerAddress1">Gatuadress:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerAddress1" name="address1" value="${userLoggedIn.address1}">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerAddress2">Postnr och ort:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerAddress2" name="address2" value="${userLoggedIn.address2}">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerPhonenumber">Telefonnr:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerPhonenumber" name="phonenumber" value="${userLoggedIn.phoneNumber}">
    </div>
  </div>  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Uppdatera</button>
      <a href="/index.jsp" class="btn btn-primary" role="button">Avbryt</a>
      <a href="/user/removeUser/<%=userLoggedIn.getId()%>" class="btn btn-danger" role="button">Ta bort denna användare</a>
    </div>
  </div>
</form>
	<%}%>

	</div>
</div>

</div>

	


<%@ include file="footer.jsp" %>