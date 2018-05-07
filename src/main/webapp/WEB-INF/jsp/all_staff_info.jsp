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
		<div>
			<table class="table table-bordered table-striped " style="text-align: center;line-height: 40px;">

				<thead class="thead-light ">
					<tr>
						<th scope="col">序号</th>
						<th scope="col">员工号</th>
						<th scope="col">名字</th>
						<th scope="col">工种</th>
						<th scope="col">部门</th>
						<th scope="col">状态</th>
						<th scope="col">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" varStatus="v" items="${pageInfo.list }">
						<tr>
							<th scope="row">${v.count}</th>
							<td>${s.id }</td>
							<td>${s.name }</td>
							<td>${s.type }</td>
							<td><c:if test="${s.deptId==1  }">
			生产部
		</c:if> <c:if test="${s.deptId==2  }">
			工艺部
		</c:if> <c:if test="${s.deptId==3  }">
			计划部
		</c:if> <c:if test="${s.deptId==4  }">
			质检部
		</c:if> <c:if test="${s.deptId==5  }">
			人事部
		</c:if> <c:if test="${s.deptId==6  }">
			管理部
		</c:if></td>
		<td>${s.state }</td>
		<td><a class="btn btn-outline-dark" href="staff_info?id=${s.id}">查看</a>
			
		</td>
		
						</tr>


					</c:forEach>



				</tbody>


			</table>
		</div>
		<div class="  " style="text-align: center;">
			<div class="">
				<p class="text-dark">一共${pageInfo.pages}页,当前第${pageInfo.pageNum}页</p>
			</div>
			<div class=" ">
			

				<ul class="justify-content-center pagination">



					<li class="page-item"><a class="btn btn-outline-dark"
						href="all_staff_info?page=${pageInfo.firstPage}">第一页</a></li>
					<li class="page-item"><a class="btn btn-outline-dark"
						href="all_staff_info?page=${pageInfo.prePage}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">上一页</span>
					</a></li>
					<li class="page-item"><a class="btn btn-outline-dark"
						href="all_staff_info?page=${pageInfo.nextPage}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span> <span class="sr-only">下一页</span>
					</a></li>
					<li class="btn-outline-dark"><a class="btn btn-outline-dark"
						href="all_staff_info?page=${pageInfo.lastPage}">最后一页</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>