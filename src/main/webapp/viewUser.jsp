<%@ include file ="header.jsp"%>

<div class="container">	
<div class="row">
	<div class="col-sm-12">



<form class="form-horizontal" role="form" method="post" action="/user/updateUser">

  <div class="form-group">  
  	<div class="col-sm-2"></div>
    <div class="col-sm-10">
    <label>Uppdatera Little Bronie</label>
    </div>
  </div>
  <div class="form-group">  
    <label class="control-label col-sm-2" for="registerUsername">Användarnamn:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerUsername" name="username" value="${user.name}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="registerPassword">Lösenord:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="registerPassword" name="password" value="">
    </div>
  </div>
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerName">Namn:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerName" name="name" value="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerEmail">Email:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="registerEmail" name="email" value="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerAddress1">Gatuadress:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerAddress1" name="address1" value="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerAddress2">Postnr och ort:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerAddress2" name="address2" value="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerPhonenumber">Telefonnr:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerPhonenumber" name="phonenumber" value="">
    </div>
  </div>  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Uppdatera</button>
    </div>
  </div>
</form>








	</div>
</div>

</div>

	


<%@ include file="footer.jsp" %>