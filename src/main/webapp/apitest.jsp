<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Api Test</title>
</head>
<body>
	<h1>Listing all content</h1>
	<button id="testapibutton">Test API</button>
	<div id="result">
	
	</div>
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>	
<script type="text/javascript">
	$(document).ready(function() {
	
	$("#testapibutton").click(function(event) {
		$.ajax({
            url : '/apitest',
            success : function(data) {
                $('#result').html(data);
            }
        });
	});
	
	}); 
</script>	
</body>
</html>