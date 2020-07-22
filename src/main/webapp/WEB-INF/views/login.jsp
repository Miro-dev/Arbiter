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
<!-- <script>
	window.onload = function() {
		var credentials = $("#state-bar");
		var key = $("#name");
		var sendBtn = $("#send-button");

		sendBtn
				.click(function(event) {

					var parameters = {
						credentials : credentials,
						key : key
					};

					$
							.ajax({
								type : 'POST',
								data : parameters,
								contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
								dataType : "json",
								url : "${pageContext.request.contextPath}/login",
								success : function(data) {
									stateBar.html(data);
								},
								error : function(data) {
									stateBar.html("Server Error. "
											+ data.content);
								}
							});
				});
	}
</script>
 -->
</head>
<body>

<div id="login">
		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="managerPanel"
							method="post">
							<h3 class="text-center text-info">Arbiter Login</h3>
							<div class="form-group">
								<label for="username" class="text-info">Credentials:</label>
								<br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Key:</label>
								<br>
								<input type="text" name="password" id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info">
									<span>Remember me</span>
									 
									<span>
										<input id="remember-me" name="remember-me" type="checkbox">
									</span>
								</label>
								<br>
								<input type="submit" name="submit" class="btn btn-info btn-md"
									value="submit">
							</div>
							<div id="register-link" class="text-right">
								<a href="#" class="text-info">Register here</a>
							</div>
						</form>
					</div>
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