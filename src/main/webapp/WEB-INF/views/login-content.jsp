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
		<div class="page-header bg-secondary">
			<div class="d-flex justify-content-end">
				<div class="mr-5">
					<h1>You're not currently logged in.</h1>
				</div>
			</div>
		</div>
		
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
		
		Or create a new user: <a href="users/create" class="btn btn-primary">Create</a>
	</body>
</html>