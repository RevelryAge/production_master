<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

			<h2>生产工票信息（总）</h2>
		</div>
		<div>
			<table class="table table-bordered table-striped "
				style="text-align: center; line-height: 40px;">

				<thead class="thead-light ">
					<tr>
						<th scope="col">序号</th>
						<th scope="col">工票号</th>
						<th scope="col">零部件名</th>
						<th scope="col">工序号</th>
						<th scope="col">派单员</th>
						<th scope="col">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" varStatus="v" items="${pageInfo.list }">
						<tr>
							<th scope="row">${v.count}</th>
							<td>${s.id }</td>
							<td>${s.partName }</td>
							<td>${s.partTechnologyId }</td>
							<td>${s.planStaffId }</td>
							<td><a class="btn btn-outline-dark"
								href="manufacture_info?id=${s.id}">查看详情</a></td>

						</tr>


					</c:forEach>



				</tbody>


			</table>
			<div class="row justify-content-center">
				<c:if test="${sessionScope.staff.deptId==3||sessionScope.staff.deptId==6 }">
					<a class="btn btn-outline-dark"
						href="manufacture_go_add">添加</a>
				</c:if>
				
		</div>
		<div class="  " style="text-align: center;">
			<div class="">
				<p class="text-dark">一共${pageInfo.pages}页,当前第${pageInfo.pageNum}页</p>
			</div>
			<div class=" ">


				<ul class="justify-content-center pagination">



					<li class="page-item"><a class="btn btn-outline-dark"
						href="manufacture_all?page=${pageInfo.firstPage}">第一页</a></li>
					<li class="page-item"><a class="btn btn-outline-dark"
						href="manufacture_all?page=${pageInfo.prePage}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span> <span class="sr-only">上一页</span>
					</a></li>
					<li class="page-item"><a class="btn btn-outline-dark"
						href="manufacture_all?page=${pageInfo.nextPage}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span> <span class="sr-only">下一页</span>
					</a></li>
					<li class="btn-outline-dark"><a class="btn btn-outline-dark"
						href="all_staff_info?page=${pageInfo.lastPage}">最后一页</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>