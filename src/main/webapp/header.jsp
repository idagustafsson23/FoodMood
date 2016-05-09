<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ page import="com.foodmood.models.User" %>
<%@ page import="com.foodmood.models.Recipe" %>
<%@ page import="com.foodmood.models.Ingredient" %>
<%@ page import="com.foodmood.models.FoodTag" %>
<%@ page import="com.foodmood.models.RecipeComponent" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<title id="pageTitle">LIJC</title>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="/style/style.css" >

	<%@ page isELIgnored="false" %>
	<meta charset="utf-8">
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
      <a class="navbar-brand" href="/index.jsp">LIJC</a>
    </div-->
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/index.jsp">LIJC</a></li>  
       	<li><a href="#"><span class="glyphicon glyphicon-wrench"></span> Food</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-fire"></span> Mood</a></li>
        <li>
  	
    	<form action="/recipe/searchrecipe" method="POST">
    		<label id="lblSearch">Sök Recept:</label><input type="search" name="inputsearch" id="txtRecipeSearch" /> 
    		<input type="submit" id="btnSearch" />
    	</form>
        </li>
      
      </ul>
      	
	
 
      <ul class="nav navbar-nav navbar-right">	
		  
		  <%
			boolean loggedIn = false;
			User userLoggedIn = null;
			if(request.getAttribute("userLoggedIn") != null) {
				loggedIn = true;
				userLoggedIn = (User) request.getAttribute("userLoggedIn");
				session.setAttribute("userLoggedIn", userLoggedIn);
			}else if(session.getAttribute("userLoggedIn") != null) {
				loggedIn = true;
				userLoggedIn = (User) session.getAttribute("userLoggedIn");
			}
		%>
				
			<%if(!loggedIn) { %>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-in" ></span> Login/register<span class="caret"></span></a>
				<ul id="login-dropdown" class="dropdown-menu">
					<li>
						<div class="row">
							<div class="col-md-12" id="login-div">
								<form role="form" method="GET" action="/user/loginUser">
									<div>
										<h2 class="text-center form-signin-heading">Login</h2>
									</div>
									<div class="form-group col-md-12">
										<input type="text" name="username" placeholder="Username">
									</div>
									<div class="form-group col-md-12">
										<input type="password" name="password" placeholder="Password">
									</div>
									<div class="form-group col-md-12">
										<input type="submit" class="btn btn-info" value="Login">
									</div>
									<div class="form-group col-md-12">
									<a href="/registerUser.jsp">New user? Register here.</a>
									</div>
								</form>
							</div>
						</div>
					</li>
				</ul>
			</li>
			<%} %>
			
			<%if(loggedIn) { %>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=userLoggedIn.getName() %><span class="caret"></span></a>
				<ul id="user-dropdown" class="dropdown-menu">
					<li>
						<div class="row" id="">
							<div class="col-md-12" id="logout-div">
									<div class="form-group">
										<a href="/user/userPage/<%=userLoggedIn.getId()%>" class="btn btn-info btn-block" role="button">My page</a>	
									</div>		
									<form role="form" method="GET" action="/user/logoutUser">
										<div class="form-group">
											<input type="submit" class="btn btn-info btn-block" value="Log out">
										</div>
									</form>
							</div>
						</div>			
					</li>
				</ul>
			</li>
			<%} %>
		 
        
        
      </ul>
    </div>
  </div>
</nav>



<div class="container">
<div class="jumbotron">
  <div class="container text-center">
    <h1>Poop & Mood!</h1>      
    <p>by LIJC &reg;</p>
  </div>
</div>
</div>


