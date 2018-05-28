<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap-4.0.0.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/locales/bootstrap-datepicker.zh-CN.js"></script>
<link href="css/bootstrap-4.0.0.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
<link href="css/form-validation.css" rel="stylesheet">
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
			<h3 class="four">添加生产计划</h3>
			<form action="plan_add" style="line-height: 50px;" method="post">
				<div class="col d-none">
					创建时间 <input
						class="form-control" id="datepicker1" readonly="readonly"
						name="createDate" type="text" required>
				</div>
				录入人: <input type="number" readonly class="form-control"
					value="${sessionScope.staff.id }" name="createStaffId">
				
					计划完成时间 <input
						class="form-control" id="datepicker2" readonly="readonly"
						name="planEnd" type="text" required>
				
				plan staff id: <input type="number" required  class="form-control"
					name="planStaffId">
				<p class="text-warning"
					style="line-height: 18px; text-align: center;" role="alert">${message}</p>
				<input type="submit" name="button"
					class=" btn btn-info" value="添加">
					</form>
		</div>
		
	</div>
	
	<script>
		$(function() {
			var date = new Date();
			$("#datepicker2").datepicker({
				format : "yyyy-mm-dd",
				autoclose : true,
				todayBtn : true,
				todayHighlight : true,
				showMeridian : true,
				pickerPosition : "bottom-left",
				language : 'zh-CN',//中文，需要引用zh-CN.js包
				startView : 2,//月视图0~4 分别对应分、时、日、月、年
				minView : 2,
				startDate: date
				
			//日期时间选择器所能够提供的最精确的时间选择视图
			});
			$("#datepicker1").datepicker({
				format : "yyyy-mm-dd",
				autoclose : true,
				todayBtn : true,
				todayHighlight : true,
				showMeridian : true,
				pickerPosition : "bottom-left",
				language : 'zh-CN',//中文，需要引用zh-CN.js包
				startView : 0,//月视图0~4 分别对应分、时、日、月、年
				minView : 0,
				initialDate:date
			//日期时间选择器所能够提供的最精确的时间选择视图
			});
		});
	</script>
</body>
</html>
