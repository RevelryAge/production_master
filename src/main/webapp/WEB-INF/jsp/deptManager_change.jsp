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
	box-sizing: border-box;
	width: 600px;
	padding: 2em 2em;
	position: absolute;
	left: 30%;
	top: 30%;
	line-height: 1.42857143;
	color: #333;
	box-sizing: border-box;
	background-color: white;
	color: #333;
	border: 1px solid rgba(213, 213, 214, 0.85);
}
.two {
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.4);
	
	
	font-size: 1em;
	
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="unit/navbar.jsp"></jsp:include>
	<div class="one">
	<div class="two">
				
				<h2 >输入你想晋升的员工</h2>
			</div>
		<form action="deptManager_change" method="post">
		
			<div class="form-group row">
				<label for="inputStaffId" class="col-sm-2 col-form-label">晋升员工号</label>
				<div class="col-sm-10">
					<input type="num" class="form-control" name="staffId"
						id="inputStaffId" placeholder="员工号">
				</div>

			</div>
			<p class="text-warning"
				style="line-height: 18px; text-align: center;" role="alert">${message}</p>
			<div style="line-height: 18px; text-align: center;">
				<button type="submit" class="btn btn-primary mb-2">确认修改</button>
			</div>
		</form>
	</div>



</body>

</html>