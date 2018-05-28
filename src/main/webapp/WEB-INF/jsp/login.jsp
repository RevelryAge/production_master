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
.half_blue {
	background: #00C6D7;
	position: relative;
	padding: 11em 0;
	width: 100%;
}

.one {

	margin: 7em auto;
	width: 400px;
	padding: 2em 2em;
	position: absolute;
	left: 35%;
	top: 30%;
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

div {
	display: block;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="half_blue">


		<div class="one">
			<div class="two">
				<h2>兰志</h2>
				<div class="three">汽车零部件管理系统</div>
			</div>
			<div>
				<h3 class="four">登陆</h3>
				<form action="login" style="line-height: 50px;" method="post">

					登陆账号：<input type="number" required class="form-control" name="id">
					密&nbsp;&nbsp;&nbsp;&nbsp;码: <input type="password" required class="form-control" name="password" >
					<div style="text-align: center;">
						<p class="text-warning"
							style="line-height: 18px; color:red; text-align: center;" role="alert">${message}</p>
						<input type="submit"  class=" btn btn-info" value="登陆">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>