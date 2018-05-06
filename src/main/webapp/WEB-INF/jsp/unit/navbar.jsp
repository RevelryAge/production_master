
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <jsp:include
	page="logo.jsp"></jsp:include> <c:if
	test="${sessionScope.staff.deptId==5  }">
	<jsp:include page="navbar_5_s.jsp"></jsp:include>
</c:if> 

<jsp:include page="navbar_right.jsp"></jsp:include>
</nav>
