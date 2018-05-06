<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script> -->
 <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap-4.0.0.js"></script>
     <link href="css/bootstrap-4.0.0.css" rel="stylesheet">
<style type="text/css">
#one {
	background: #79DCD3;
}

#two {
	position: fixed;
	width: 300px;
	height: 300px;
	top:-28%;
	right: 0;
	bottom: 0;
	left: 0;
	margin: auto;
}
</style>

<title>Insert title here</title>
</head>
<body id="one">
<div id="two" >
  <div   align="center">
      <h2  style="font-weight:bold;font-size:120px;color: #C0F9FE;">兰志</h2>
      <br>
      <br>
      <div class="text-muted">汽车零部件管理系统
      <br>现在时间是  ${now}</div>
      <br>
      <br>
      <br>
      <br>
      <p><a class="btn btn-link" style="font-size: 25px; " href="login" >登&nbsp;陆</a></p>
  </div>
</div>
</body>
</html>