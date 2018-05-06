<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="dropdown" >
	<a class="nav-link dropdown-toggle"
			href="#" id="staffName" role="button" data-toggle="dropdown"
			aria-haspopup="true"style="color: white; " aria-expanded="false"> &nbsp&nbsp&nbsp&nbsp&nbsp${sessionScope.account.staffName } </a>
			<div class="dropdown-menu" aria-labelledby="staffName">
				<a class="dropdown-item" href="selfInfo">个人信息</a> 
				<a	class="dropdown-item" href="goupdatePassword">修改密码</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="logout">退出登陆 </a>
			</div>
			</div>
</body>
</html>