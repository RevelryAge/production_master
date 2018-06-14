
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <jsp:include
	page="logo.jsp"></jsp:include>
<ul class="navbar-nav mr-auto">
	<c:if
		test="${sessionScope.staff.deptId==5||sessionScope.staff.deptId==6 }">
		<jsp:include page="navbar_5_s.jsp"></jsp:include>
	</c:if>

	<c:if
		test="${sessionScope.staff.deptId==2 }">
		<jsp:include page="navbar_2_s.jsp"></jsp:include>
	</c:if>
	<c:if
		test="${sessionScope.staff.deptId==1 }">
		<jsp:include page="navbar_2_s.jsp"></jsp:include>
		<jsp:include page="navbar_1.jsp"></jsp:include>
	</c:if>
	<c:if
		test="${sessionScope.staff.deptId==3&&sessionScope.account.grade==2 }">
		<jsp:include page="navbar_3.jsp"></jsp:include>
	</c:if>
	<c:if
		test="${sessionScope.staff.deptId==6 }">
		<jsp:include page="navbar_3.jsp"></jsp:include>
	</c:if>
	<c:if
		test="${sessionScope.staff.deptId==4 }">
		<jsp:include page="navbar_2_s.jsp"></jsp:include>
		<jsp:include page="navbar_1.jsp"></jsp:include>
	</c:if>
	<c:if
		test="${sessionScope.staff.deptId==4&&sessionScope.account.grade==2 }">
		
		<jsp:include page="navbar_4.jsp"></jsp:include>
	</c:if>
	<c:if
		test="${sessionScope.staff.deptId==3||sessionScope.staff.deptId==6}">
		<jsp:include page="navbar_3_s.jsp"></jsp:include>
	</c:if>
	<c:if
		test="${sessionScope.staff.deptId==6 }">
		<jsp:include page="navbar_6.jsp"></jsp:include>
	</c:if>
</ul>
<jsp:include page="navbar_right.jsp"></jsp:include> </nav>
