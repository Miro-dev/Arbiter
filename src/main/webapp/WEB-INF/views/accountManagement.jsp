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

	<div id="login">
		<h1 class="text-center text-primary">Account Management</h1>

		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<form method="get" action=""><input class="btn btn-dark"
						type="submit" value="Logout" formaction="login" /> <input
						class="btn btn-dark" type="submit" value="Manager Panel"
						formaction="managerPanel" formmethod="post" /></form>
			</div>
		</div>
			<div id="login-row"
			class="row justify-content-center align-items-center">
				<div id="login-column" class="col-sm-7">
					<div id="login-box" class="col-md-7"><form:form
							id="create-form" class="form" modelAttribute="manager">
							<h3 class="text-center text-info">Create Account</h3>
							<div class="form-group"><form:label path="name"
									class="text-info" for="credentials">Credentials:
									 </form:label> <br> <form:input path="name" type="text"
									name="credentials" id="credentials" class="form-control"
									required='true' /></div>
							<div class="form-group"><form:label path="password"
									for="key" class="text-info">Key:</form:label> <br> <form:input
									path="password" type="text" name="password" id="password"
									class="form-control" required='true' /></div>
							<div class="form-group">

								<div class="btn-group btn-group-toggle" data-toggle="buttons"><label
									class="btn btn-secondary active" id="engineer"> <input
										type="radio" name="options" id="option1" autocomplete="off"
										checked> Engineer
								</label> <label class="btn btn-secondary" id="manager"> <input
										type="radio" name="options" id="option2" autocomplete="off">
										Manager
								</label></div> <input class="btn btn-dark" type="submit" value="Submit"
								formaction="createManager" id="submit-form-button"
								formmethod="post" />
							</div>
							${responseFromDB_EmployeeCreation}
						</form:form></div>

					<div id="login-box" class="col-md-7"><form:form
							id="create-form-accessLevel" class="form" formmethod="post"
							action="/Arbiter/accountManagement/createAccessLevel"
							modelAttribute="accessLevel">
							<h3 class="text-center text-info">Create Access Level</h3>
							<div class="form-group"><form:label path="name"
									class="text-info" for="credentials-accessLevel">Name:
									 </form:label> <br> <form:input path="name" type="text"
									name="credentials-accessLevel" id="credentials-accessLevel"
									class="form-control" required='true' /></div>
							<input class="btn btn-dark" type="submit" value="Submit"
								id="submit-form-button-accessLevel" />
								${responseFromDB_AccessLevel} </form:form>

						<form action="/Arbiter/accountManagement/deleteAccessLevel"
						method="post">
							<div class="form-group"><h3 class="text-center text-info">Delete
									AccessLevel</h3> <input type="text" class="form-control"
								name="deleteAccessLevel" placeholder="Enter name"></div>
							<button type="submit" class="btn btn-primary">Submit</button>
							${responseFromDB_AccessLevel_Deletion}
					</form></div>



			</div>

		</div>
	</div>
	</div>
	</div>

	<!-- 	<div class="container">
		<h1 class="text-center text-primary">Manager Tables</h1>
		<div class="row">
			<div class="col-md-6">
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
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">Handle</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td colspan="2">Larry the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>
			</div>
		</div>
	</div>
	</div> -->

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

	<script>
		$("#engineer").click(
				function() {
					$("#submit-form-button").attr("formaction",
							"/Arbiter/accountManagement/createEngineer");
					$("#create-form").attr("modelAttribute", "engineer");
				});

		$("#manager").click(
				function() {
					$("#submit-form-button").attr("formaction",
							"/Arbiter/accountManagement/createManager");
					$("#create-form").attr("modelAttribute", "manager");
				});
	</script>


</body>
</html>