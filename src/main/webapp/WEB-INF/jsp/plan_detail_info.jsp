<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	width: 900px;
	padding: 1em 1em;
	position: relative;
	left: 10%;
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

			<h2>生产计划</h2>
		</div>
		<div>
			<table class="table table-bordered table-striped "
				style="text-align: center; line-height: 40px;">

				<thead class="thead-light ">
					<tr>
						<th scope="col">序号</th>
						<th scope="col">计划详情号</th>
						<th scope="col">零部件号</th>
						<th scope="col">数量</th>
						<th scope="col">合格数量</th>
						<th scope="col">不合格数量</th>
						<c:if
							test="${sessionScope.staff.deptId==3&&sessionScope.account.grade==2 }">
							<th scope="col">操作</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" varStatus="v" items="${pageInfo.list }">
						<tr>
							<th scope="row">${v.count}</th>
							<td>${s.id }</td>
							<td>${s.partId }</td>
							<td>${s.num }</td>
							<td>${s.qualifiedNum }</td>
							<td>${s.unqualifiedNum }</td>

							<c:if
								test="${sessionScope.staff.deptId==3&&sessionScope.account.grade==2 }">

								<td><c:if test="${plan.state=='计划录入' }">
										<a class="btn btn-outline-dark"
											href="plan_detail_delete?planDetailId=${s.id}">删除</a>
										<a class="btn btn-outline-dark"
											href="plan_detail_go_change?planDetailId=${s.id}">修改</a>
									</c:if> <c:if test="${plan.state!='计划录入' }">
										<button type="button" class="btn btn-outline-dark" disabled>修改</button>
									</c:if></td>
							</c:if>
						</tr>


					</c:forEach>



				</tbody>


			</table>

			<div class="row justify-content-center">
				<c:if test="${plan.state=='计划录入' }">
					<c:if
						test="${sessionScope.staff.deptId==3&&ssessionScope.account.grade>=2 }">
						<a class="btn btn-outline-dark"
							href="plan_detail_go_add?planId=${plan.id}">添加</a>
						<a class="btn btn-outline-dark"
							href="plan_complete?planId=${plan.id}">完成</a>
					</c:if>
					<c:if test="${sessionScope.staff.deptId==6 }">
						<a class="btn btn-outline-dark"
							href="plan_detail_go_add?planId=${plan.id}">添加</a>
						<a class="btn btn-outline-dark"
							href="plan_complete?planId=${plan.id}">录入完成</a>
					</c:if>
				</c:if>
				<c:if test="${plan.state=='计划分配' }">
					<c:if
						test="${sessionScope.staff.deptId==3&&ssessionScope.account.grade>=2||sessionScope.staff.deptId==6 }">
						<a class="btn btn-outline-dark"
							href="plan_do?planId=${plan.id}">加工</a>
					</c:if>
					
				</c:if>
				<c:if test="${plan.state=='加工' }">
					<c:if
						test="${sessionScope.staff.deptId==4&&ssessionScope.account.grade>=2||sessionScope.staff.deptId==6 }">
						<a class="btn btn-outline-dark"
							href="plan_checked?planId=${plan.id}">完成</a>
					</c:if>
					
				</c:if>
			</div>
		</div>
		<div class="  " style="text-align: center;">
			<p class="text-warning"
				style="line-height: 18px; text-align: center;" role="alert">${message}</p>
			<div class="">
				<p class="text-dark">一共${pageInfo.pages}页,当前第${pageInfo.pageNum}页</p>
			</div>
			<div class=" ">


				<ul class="justify-content-center pagination">



					<li class="page-item"><a class="btn btn-outline-dark"
						href="plan_detail_info?id=${plan.id}&page=${pageInfo.firstPage}">第一页</a></li>
					<li class="page-item"><a class="btn btn-outline-dark"
						href="plan_detail_info?id=${plan.id}&page=${pageInfo.prePage}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">上一页</span>
					</a></li>
					<li class="page-item"><a class="btn btn-outline-dark"
						href="plan_detail_info?id=${plan.id}&page=${pageInfo.nextPage}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">下一页</span>
					</a></li>
					<li class="btn-outline-dark"><a class="btn btn-outline-dark"
						href="plan_detail_info?id=${plan.id}&page=${pageInfo.lastPage}">最后一页</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>
