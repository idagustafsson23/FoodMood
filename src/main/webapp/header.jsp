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
	<title id="pageTitle">LIJCO</title>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="/style/jquery-ui.min.css">
	<script src="/javascript/jquery.js"></script>
	<script src="/javascript/jquery-ui.min.js"></script>

	<link rel="stylesheet" type="text/css" href="/style/style.css" />
	<script type="text/javascript" src="/javascript/foodmood.js"></script>
	
	
	
	<script type="text/javascript" src="/javascript/controls.js"></script>
	
	

	<link rel="stylesheet" type="text/css" href="/style/style.css" >
	


	<%@ page isELIgnored="false" %>
	<meta charset="utf-8" />
</head>


<body>

<div id="wrapAll">
<div class="bg"></div>
<div class="jumbotron">
<div class="container">
  <div class="container text-center" id = "jumbotrontext">
    <h1>FoodMood</h1>      

    <p>by LIJCO</p>

  <form method="GET" action="recipe/searchrecipe">  

  <div id="custom-search-input"> 
     <div class="input-group col-md-12">
        <input type="text" class="form-control input-lg" placeholder="Sök Recept" name="inputsearch" />
           <span class="input-group-btn">
               <button id="btnSearch" class="btn btn-info btn-lg" type="submit">
                  <i class="glyphicon glyphicon-search"></i>
               </button>
            </span>
      	</div>
   	</div>
   </form>
  </div>
</div>
</div>

<nav class="navbar navbar-inverse" id="navigationBar">
  <div class="container-fluid">
  
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/index.jsp">LIJCO</a></li>  
       	<li><a href="/recipe/getAllRecipes"><span class="glyphicon glyphicon-cutlery"></span> ALLA RECEPT</a></li>
       	<li><a href="/addRecipe.jsp"><span class="glyphicon glyphicon-pencil"></span> LÄGG TILL RECEPT</a></li>                     
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
								<form role="form" method="POST" action="/user/loginUser">
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