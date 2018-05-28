<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap-4.0.0.js"></script>
<link href="css/bootstrap-4.0.0.css" rel="stylesheet">
<style type="text/css">
.one {
	margin: 7em auto;
	width: 400px;
	padding: 2em 2em;
	position: absolute;
	left: 35%;
	top: 5%;
	line-height: 1.42857143;
	color: #333;
	box-sizing: border-box;
	background-color: white;
	border: 1px solid rgba(213, 213, 214, 0.85);
}

.two {
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.4);
	position: absolute;
	top: -45%;
	left: 27%;
	font-size: 1em;
	color: white;
	text-align: center;
}

h2 {
	font-size: 4em;
}

.three {
	font-size: 1.3em;
}

.four {
	font-size: 1.8em;
	font-weight: 400;
	text-align: center;
	margin-bottom: 0.7em;
	color: #333;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="unit/navbar.jsp"></jsp:include>


	<div class="one">

		<div>
			<h3 class="four">添加账号</h3>
			<form  action="addaccount" style="line-height: 50px;" method="post">

				员工号：<input type="number" required class="form-control"
					name="staffId"> 密&nbsp;&nbsp;码: <input type="password" required
					class="form-control" id="password" name="password">

				确认密码: <input type="password" id="password2" required class="form-control"
					id="password2">
				<div style="text-align: center;">
					<p class="text-warning"
						style="line-height: 18px; text-align: center;" role="alert">${message}</p>
					<input type="submit" name="button" 
						onclick="return insertManager()" class=" btn btn-info" value="添加">
				</div>
			</form>
		</div>
	</div>
	<script>
		function insertManager() {
			var password = document.getElementById("password").value;
			var repassword = document.getElementById("password2").value;
			if (password != repassword) {
				window.alert("您输入的新密码与确认密码确认不一致");
				 
				return false;

			}
			return true;
		}
	</script>
</body>
</html>
