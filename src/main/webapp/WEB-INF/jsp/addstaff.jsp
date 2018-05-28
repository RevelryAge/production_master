<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<script src="js/holder.min.js"></script>
<style type="text/css">
.one {
margin-bottom: 1.2em;

	color: #333;
	border: 1px solid rgba(213, 213, 214, 0.85);
}
.two{
	margin: 0 auto;
	margin-top: 1%;
}
.four {
	font-size: 1.8em;
	font-weight: 400;
	text-align: center;
	margin-bottom: 1.2em;
	color: #333;
}</style>
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="unit/navbar.jsp"></jsp:include>
<div class=" row two col-md-6 justify-content-md-center  ">
	<div class="row col  one justify-content-md-center ">

		<div class="col-md  container" style="">

			<h3 class="four">员工信息</h3>
			<form class="needs-validation" action="addstaff" method="psot"
				novalidate="">
				<div class="row">
					<div class="col">
						<label for="Name" _msthash="1815554">名字</label> <input
							class="form-control" name="name" id="Name" required=""
							type="text" placeholder="" value="">
						<div class="invalid-feedback" _msthash="1681017">需要有效的名字。</div>
					</div>
					<div class="col ">
						<label for="sex" _msthash="1816191">性别</label>
						<div class=" form-check">
							<div class="custom-control custom-radio">
								<input name="sex" class="custom-control-input" id="male"
									required="" type="radio" value="男" checked> <label
									class="custom-control-label" for="male" _msthash="1862575">男</label>
							</div>
							<div class="custom-control custom-radio">
								<input name="sex" class="custom-control-input" id="female"
									required="" value="女" type="radio"> <label
									class="custom-control-label" for="female" _msthash="1863225">女</label>
							</div>
						</div>
					</div>
					<div class="col">
						<label for="datepicker2" _msthash="1456122">出生年月日</label> <input
							class="form-control" id="datepicker2" readonly="readonly" name="birthday" type="text"
							required>
						<div class="invalid-feedback" _msthash="1612734">请提供有效的出生年月日。</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label for="phone" _msthash="1454414">手机或电话</label> <input
							id="phone" class="form-control" name="phone"
							pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$"
							required="required" type="text" placeholder="phone" />

						<div class="invalid-feedback" style="width: 100%;"
							_msthash="1682213">请输入正确的手机或电话 。</div>
					</div>

					<div class="col">
						<label for="email" _msthash="1454973">电子邮件</label> <input
							class="form-control" id="email" type="email" required
							name="email" placeholder="you@example.com you@example">
						<div class="invalid-feedback" _msthash="1334944">请输入电子邮件地址。</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label for="address" _msthash="1455532">地址</label> <input
							class="form-control" id="address" name="address" required=""
							type="text" placeholder="地址">
						<div class="invalid-feedback" _msthash="1335503">请输入地址。</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label for="state" _msthash="1818986">状态</label> <select
							class="custom-select d-block w-100" name="state" id="state"
							required="" _msthash="63401"><option value="">选择...</option>
							<option value="入职">入职</option>
							<option value="在职">在职</option>
							<option value="离职">离职</option>
						</select>
						<div class="invalid-feedback" _msthash="1683734">请提供有效的状态。</div>
					</div>

					<div class=" col">
						<label for="deptId" _msthash="1844987">部门号</label> <select
							class="custom-select d-block w-100" name="deptId" id="deptId"
							required="" _msthash="6344121"><option value="">选择...</option>
							<option value="1">生产部</option>
							<option value="2">工艺部</option>
							<option value="3">计划部</option>
							<option value="4">质检部</option>
							<option value="5">人事部</option>
							<c:if test="${sessionScope.staff.deptId==6  }">
								<option value="6">管理部</option>
							</c:if>
						</select>
						<div class="invalid-feedback" _msthash="1123734">请提供有效的部门。</div>
					</div>
					<div class="col">
						<label for="datepicker1" _msthash="14515132">加入日期</label> <input
							class="form-control" readonly="readonly" id="datepicker1" name="joinDate" type="text"
							required>
						<div class="invalid-feedback" _msthash="1612214">请提供有效的加入日期。</div>
					</div>
					<div class=" col">
						<label for="type" _msthash="18442">工种</label> <select
							class="custom-select d-block w-100" name="type" id="type"
							required="" _msthash="1213"><option value="">选择...</option>
							<option value="车工">车工</option>
							<option value="铣工">铣工</option>
							<option value="磨工">磨工</option>
							<option value="工艺员">工艺员</option>
							<option value="计划分配员">计划分配员</option>
							<option value="检验">检验</option>
							<option value="文员">文员</option></select>
						<div class="invalid-feedback" _msthash="11123734">请提供有效的工种。</div>

					</div>
				</div>

				<br>
				<div class="row justify-content-center">

					<button class="btn btn-info" type="submit">提交</button>
				</div>
			</form>
		</div>

	</div>
	</div>
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';

			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');

						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();
	</script>

	<script>
		$(function() {
			$("#datepicker2").datepicker({
				format : "yyyy-mm-dd",
				autoclose : true,
				todayBtn : true,
				todayHighlight : true,
				showMeridian : true,
				pickerPosition : "bottom-left",
				language : 'zh-CN',//中文，需要引用zh-CN.js包
				startView : 2,//月视图0~4 分别对应分、时、日、月、年
				minView : 2
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
				startView : 2,//月视图0~4 分别对应分、时、日、月、年
				minView : 2
			//日期时间选择器所能够提供的最精确的时间选择视图
			});
		});
	</script>
</body>
</html>
</html>