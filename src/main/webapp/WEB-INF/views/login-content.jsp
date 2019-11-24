<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
	</head>
	<body>
		<h1>Please enter your email address and password below.</h1>
		
		<form id="loginForm" action="/login/submit">
			Email: <input type="text" name="email">
			Password: <input type="password" name="password">
			<input type="submit" value="Login">
		</form>
		
		<c:if test="${ error != null }">
			<div class="alert alert-primary" role="alert">
  				${ error }
			</div>
		</c:if>
		
		Or create a new user: <button id="createUserButton" onclick=""> Create </button>
	</body>
</html>