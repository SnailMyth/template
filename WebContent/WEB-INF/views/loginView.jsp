<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/base.js"></script>
<script src="js/jquery-2.1.4.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.h60 {
	height: 60px;
}
</style>
<script type="text/javascript">
	function login() {
		var username = document.getElementById("username").value.trim();
		var password = document.getElementById("password").value.trim();
		var url = baseUrl + "login";
		$.ajax({
			type : "POST",
			url : url,
			dataType : "json",
			data : {
				username : username,
				password : password
			},
			success : function(data) {
				console.log(data);
				if (data.data == null) {
					alert(data.error_message);
				} else {
					alert("login success");
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="container"
		style="margin-top: 10%; background-image: img/back.jpg">
		<div class="jumbotron">
			<h1>Welcome Back!</h1>
			<fieldset style="">
				<legend>check</legend>
				<form method="POST" class="bs-example bs-example-form" action="#"
					style="margin-left: 20%; width: 500px; height: 200px;">
					<div class="input-group h60" style="">
						<span class="input-group-addon">@</span> <input id="username"
							name="username" type="text" class="form-control h60"
							placeholder="username">
					</div>
					<div class="input-group h60" style="margin-top: 5px;">
						<span class="input-group-addon">@</span> <input id="password"
							name="password" type="password" class="form-control h60">
					</div>
				</form>
				<div class="input-group h60" style="margin-top: 10px;">
					<input type="submit" value="Sign In" class="btn btn-primary"
						style="margin-left: 190px;" onclick="login()" />
				</div>
			</fieldset>
		</div>
	</div>

</body>
</html>
