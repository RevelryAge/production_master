<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap-4.0.0.js"></script>
<link href="css/bootstrap-4.0.0.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>


<div>
<c:if test="${sessionScope.staff.deptId==1  }">
 <jsp:include page="unit/navbar.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.staff.deptId==2  }">
 <jsp:include page="unit/navbar.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.staff.deptId==3  }">
 <jsp:include page="unit/navbar.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.staff.deptId==4  }">
 <jsp:include page="unit/navbar.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.staff.deptId==5  }">
 <jsp:include page="unit/navbar.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.staff.deptId==6  }">
 <jsp:include page="unit/navbar.jsp"></jsp:include>
</c:if>

${account.staffName }


</div>
</body>
</html>