<%@ include file ="header.jsp"%>

<div class="container">	
<div class="row">
	<div class="col-sm-12">



<form class="form-horizontal" role="form" method="post" action="/user/addUser">

  <div class="form-group">  
  	<div class="col-sm-2"></div>
    <div class="col-sm-10">
    <label>Profilbild</label>
    </div>
  </div>
  <div class="form-group">  
    <label class="control-label col-sm-2" for="registerUsername">Användarnamn:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerUsername" name="registerUsername" placeholder="">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="registerPassword">Lösenord:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="registerPassword" name="registerPassword" placeholder="">
    </div>
  </div>
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerName">Namn:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerName" name="registerName" placeholder="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerEmail">Email:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="registerEmail" name="registerEmail" placeholder="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerAddress1">Gatuadress:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerAddress1" name="registerAddress1" placeholder="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerAddress2">Postnr och ort:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerAddress2" name="registerAddress2" placeholder="">
    </div>
  </div>  
 <div class="form-group">  
    <label class="control-label col-sm-2" for="registerPhonenumber">Telefonnr:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="registerPhonenumber" name="registerPhonenumber" placeholder="">
    </div>
  </div>  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Skicka</button>
    </div>
  </div>
</form>








	</div>
</div>

</div>

	


<%@ include file="footer.jsp" %>