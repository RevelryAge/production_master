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

			<h2>详细零部件信息</h2>
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
					<td>零部件号</td>
					<td>${partinfo.id}</td>

				</tr>
				<tr>
					<th scope="row">2</th>
					<td>名称</td>
					<td>${partinfo.name}</td>

				</tr>
				<tr>
					<th scope="row">3</th>
					<td>计量单位</td>
					<td>${partinfo.unit}</td>

				</tr>
				<tr>
					<th scope="row">4</th>
					<td>图纸编号</td>
					<td>${partinfo.drawing}</td>

				</tr>
				<tr>
					<th scope="row">5</th>
					<td>检验方式</td>
					<td>${partinfo.tested }</td>

				</tr>
				<tr>
					<th scope="row">6</th>
					<td>工艺设计员id</td>
					<td>${partinfo.staffId }</td>

				</tr>

				<tr>
					<th scope="row">7</th>
					<td>状态</td>
					<td>${partinfo.state }</td>

				</tr>

			</tbody>
		</table>
		<div style="text-align: center;">
			<a class="btn btn-outline-dark"
				href="part_tech_info?id=${partinfo.id}">维护零部件工艺信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</div>
</body>
</html>