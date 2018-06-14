<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	width: 600px;
	padding: 1em 1em;
	position: relative;
	left: 28%;
	top: 20px;
	line-height: 1.42857143;
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

			<h2>员工信息（总）</h2>
		</div>
		<p class="text-warning"
				style="line-height: 18px; text-align: center;" role="alert">${message}</p>
		<div>
			<table class="table table-bordered table-striped "
				style="text-align: center; line-height: 40px;">

				<thead class="thead-light ">
					<tr>
						<th scope="col">序号</th>
						<th scope="col">部门号</th>
						<th scope="col">部门名</th>
						<th scope="col">部门经理</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" varStatus="v" items="${depts }">
						<tr>
							<th scope="row">${v.count}</th>
							<td>${s.id }</td>
							<td>${s.name }</td>
							<td>${s.staffId}</td>
						</tr>


					</c:forEach>



				</tbody>


			</table>
		</div>

	</div>

</body>
</html>