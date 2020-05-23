<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Account Management</title>
</head>

<body>

	<div class="container">
		<h1 class="text-center text-primary">Admin Panel</h1>
		<div class="row">
			<div class="col-md-6">
				<form method="get" action=""><input class="btn btn-dark"
					type="submit" value="Logout" formaction="login" /> <input
					class="btn btn-dark" type="submit" value="AccountManagement"
					formaction="accountManagement" /></form>
		</div>
	</div>


		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Developers</h3>
						<div class="pull-right"><span class="clickable filter"
							data-toggle="tooltip" title="Toggle table filter"
							data-container="body"> <i
								class="glyphicon glyphicon-filter"></i>
						</span></div>
				</div>
					<div class="panel-body"><input type="text"
						class="form-control" id="dev-table-filter" data-action="filter"
						data-filters="#dev-table" placeholder="Filter Developers" /></div>
					<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
								<th>#</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Username</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Kilgore</td>
								<td>Trout</td>
								<td>kilgore</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Bob</td>
								<td>Loblaw</td>
								<td>boblahblah</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Holden</td>
								<td>Caulfield</td>
								<td>penceyreject</td>
							</tr>
						</tbody>
					</table>

			</div>
		</div>
	</div>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Tasks</h3>
						<div class="pull-right"><span class="clickable filter"
							data-toggle="tooltip" title="Toggle table filter"
							data-container="body"> <i
								class="glyphicon glyphicon-filter"></i>
						</span></div>
				</div>
					<div class="panel-body"><input type="text"
						class="form-control" id="task-table-filter" data-action="filter"
						data-filters="#task-table" placeholder="Filter Tasks" /></div>
					<table class="table table-hover" id="task-table">
						<thead>
							<tr>
								<th>#</th>
								<th>Task</th>
								<th>Assignee</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Site Wireframes</td>
								<td>John Smith</td>
								<td>in progress</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Mobile Landing Page</td>
								<td>Kilgore Trout</td>
								<td>completed</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Add SEO tags</td>
								<td>Bob Loblaw</td>
								<td>failed qa</td>
							</tr>
							<tr>
								<td>4</td>
								<td>Migrate to Bootstrap 3</td>
								<td>Emily Hoenikker</td>
								<td>in progress</td>
							</tr>
							<tr>
								<td>5</td>
								<td>Update jQuery library</td>
								<td>Holden Caulfield</td>
								<td>deployed</td>
							</tr>
							<tr>
								<td>6</td>
								<td>Issues in IE7</td>
								<td>Jane Doe</td>
								<td>failed qa</td>
							</tr>
							<tr>
								<td>7</td>
								<td>Bugs from Sprint 14</td>
								<td>Kilgore Trout</td>
								<td>completed</td>
							</tr>
						</tbody>
					</table>
			</div>
		</div>
	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

</body>
</html>