<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


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
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">LIJC</a></li>  
       	<li><a href="#"><span class="glyphicon glyphicon-wrench"></span> Food</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-fire"></span> Mood</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
      
  
  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-in"></span> Login admin<span class="caret"></span></a>
  
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

        </li>
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


