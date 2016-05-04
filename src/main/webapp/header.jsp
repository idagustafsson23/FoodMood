<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title id="pageTitle">LIJC</title>
	<meta charset="UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="style/style.css" >

	<%@ page isELIgnored="false" %>
</head>


<body>

<div id="wrapAll">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!--div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="index.jsp">LIJC</a>
    </div-->
    <div>
    	<form action="" method="GET">
    		<label for="txtRecipeSearch">Sök Recept:<input type="search" id="txtRecipeSearch" /></label> 
    		<input type="submit" id="btnSearch" />
    	</form>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">LIJC</a></li>  
       	<li><a href="#"><span class="glyphicon glyphicon-wrench"></span> Food</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-fire"></span> Mood</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">	
		  
		  <%
			boolean loggedIn = false;
			String userLoggedIn = "";
			if(session.getAttribute("userLoggedIn") != null) {
				loggedIn = true;
				userLoggedIn = (String) session.getAttribute("userLoggedIn");
			}
		%>
				
			<%if(!loggedIn) { %>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-in" ></span> Login/register<span class="caret"></span></a>
				<ul id="login-dropdown" class="dropdown-menu">
					<li>
						<div class="row">
							<div class="col-md-12" id="login-div">
								<form role="form" method="POST" action="/user/login">
									<div>
										<h2 class="text-center form-signin-heading">Login</h2>
									</div>
									<div class="form-group col-md-12">
										<input type="text" name="userName" placeholder="Username">
									</div>
									<div class="form-group col-md-12">
										<input type="password" name="password" placeholder="Password">
									</div>
									<div class="form-group col-md-12">
										<input type="submit" class="btn btn-info" value="Login">
									</div>
									<div class="form-group col-md-12">
									<a href="#">New user? Register here.</a>
									</div>
								</form>
							</div>
						</div>
					</li>
				</ul>
			</li>
			<%} %>
			
			<%if(loggedIn) { %>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"><%=userLoggedIn %><span class="caret"></span></a>
				<ul id="user-dropdown" class="dropdown-menu">
					<li>
						<div class="row">
							<div class="col-md-12" id="login-div">
								<div class="form-group">
									<a href="#" class="btn btn-info btn-block" role="button">My page</a>	
											</div>
											<div class="form-group">
									<form role="form" method="POST" action="/logout">
										<input type="submit" class="btn btn-info btn-block" value="Log out">
									</form>
								</div>
							</div>
						</div>			
					</li>
				</ul>
			</li>
			<%} %>
					  
					
		
		<!-- li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-in"></span> Login admin<span class="caret"></span></a>
  
 		 <ul class="dropdown-menu">
          <form  action="#" role="form"
				method="POST">
				<div class="form-group">
					<label for="userName" class="control-label">Användarnamn:</label>
          			<input type="text" class="form-control" placeholder="Användarnamn" />
          		</div>
          		<div class="form-group">
					<label for="password" class="control-label">Lösenord:</label>
          			<input type="password" class="form-control" placeholder="Lösenord" />
          		</div>
          		<div class="form-group">
          			<button type="submit" class="btn btn-default">Submit</button>
          		</div>
          </form>
        </ul>

        </li-->
        
        
        
      </ul>
    </div>
  </div>
</nav>



<div class="container">
<div class="jumbotron">
  <div class="container text-center">
    <h1>Food & Mood!</h1>      
    <p>by LIJC &reg;</p>
  </div>
</div>
</div>


