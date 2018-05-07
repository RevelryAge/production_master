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
		<div class="two justify-content-center">

			<h2>个人信息</h2>
		</div>
		<table class="table table-bordered table-striped ">
			<thead class="thead-light ">
				<tr>
					<th scope="col">序号</th>
					<th scope="col">项目</th>
					<th scope="col">内容</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>员工号</td>
					<td>${staffinfo.id}</td>

				</tr>
				<tr>
					<th scope="row">2</th>
					<td>名字</td>
					<td>${staffinfo.name}</td>

				</tr>
				<tr>
					<th scope="row">3</th>
					<td>性别</td>
					<td>${staffinfo.sex}</td>

				</tr>
				<tr>
					<th scope="row">4</th>
					<td>手机号</td>
					<td>${staffinfo.phone}</td>

				</tr>
				<tr>
					<th scope="row">5</th>
					<td>email</td>
					<td>${staffinfo.email }</td>

				</tr>
				<tr>
					<th scope="row">6</th>
					<td>状态</td>
					<td>${staffinfo.state }</td>

				</tr>
				<tr>
					<th scope="row">7</th>
					<td>出生日期</td>
					<td><fmt:formatDate value="${staffinfo.birthday}"
							pattern="yyyy-MM-dd" /></td>

				</tr>
				<tr>
					<th scope="row">8</th>
					<td>工种</td>
					<td>${staffinfo.type }</td>

				</tr>
				<tr>
					<th scope="row">9</th>
					<td>入职时间</td>
					<td><fmt:formatDate value="${staffinfo.joinDate}"
							pattern="yyyy-MM-dd" /></td>

				</tr>
				<tr>
					<th scope="row">10</th>
					<td>部门号</td>
					<td>${staffinfo.deptId }</td>

				</tr>
				<tr>
					<th scope="row">11</th>
					<td>部门名</td>
					<td>${staffinfo.dept.name }</td>

				</tr>
				<tr>
					<th scope="row">12</th>
					<td>部门经理员工号</td>
					<td>${staffinfo.dept.staffId }</td>
				</tr>
				<tr>
					<th scope="row">13</th>
					<td>登陆账号</td>
					<td><c:if test="${staffinfo.account.id==null }">无账号</c:if>${staffinfo.account.id }</td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: center;">
			<a class="btn btn-outline-dark"
				href="go_change_staff?id=${staffinfo.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${staffinfo.account.id!=null }">
				<a class="btn btn-outline-dark" href="staff_quit?id=${staffinfo.id}">离职</a>
			</c:if>

		</div>
	</div>
</body>
</html>