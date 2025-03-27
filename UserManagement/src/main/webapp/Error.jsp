<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Error page</title>

<style>
    /* Centering using CSS */
    .error-container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh; /* Full viewport height */
        text-align: center;
    }
</style>

</head>

<body>

	<div class="error-container">
		<h1>Error</h1>
		<h2><%=exception.getMessage() %><br/> </h2>
	</div>
	
</body>

</html>