<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tasks for ${ user.getEmail() }</title>
		<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
	</head>
	<body>
		<div class="page-header bg-secondary">
			<div class="d-flex justify-content-end">
				<div class="mr-5">
					<h1>Welcome, ${ user.getEmail() }!</h1>
				</div>
			</div>
		</div>
		
		
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<!-- Left gutter... -->
				</div>
				<div class="col-lg">
					<div class="d-flex align-items-center">
						<h1>Your Tasks</h1>
					</div>
					
					<!-- In page center, show task list. -->
					<div class="container">
					
						<table class="table">
							<thead>
								<tr>
									<th>Task Number</th>
									<th>Created By</th>
									<th>Description</th>
									<th>Date Due</th>
									<th>Complete?</th>
								</tr>
							</thead>
							<tbody>
								<!-- If there are any tasks to show, show them. -->
								<c:choose>
									<c:when test="${ tasks.size() > 0 }">
										<c:forEach var="t" items="${ tasks }" varStatus="loop">
											<tr>
												<td>${ loop.count }</td>
												<td>${ t.getCreator().getEmail() }</td>
												<td>${ t.getTaskDescription() }</td>
												<td>${ t.getDateDue() }</td>
												<td>${ t.isComplete() }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<!-- Otherwise, let the user know nothing is available. -->
										<tr>You don't have any tasks right now.</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						
						</table>
					</div>
				</div>
				<div class="col-sm">
					<!-- Right gutter... -->
				</div>
			</div>
		</div> 
		
		
	</body>
</html>