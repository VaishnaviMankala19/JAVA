<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="container">
		<h1>Register</h1>
		<form action="RegisterServlet" method="post">
			<label for="username">USERNAME:</label>
			<input type="text" name="username" id="username" required><br>
			<label for="email">EMAIL:</label>
			<input type="email" name="email" id="email" required><br>
			<label for="password">PASSWORD:</label>
			<input type="password" name="password" id="password" required><br>
			<button type="submit">REGISTER</button>
		</form>
		<p><a href="index.html">Back To Home</a></p>
	</div>
</body>
</html>