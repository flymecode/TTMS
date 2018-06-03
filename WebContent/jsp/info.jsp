<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		

		<meta name="viewport" content="width=device-width, initial-scale=1">
<title>提示界面</title>
</head>
<body>
		<%@include file="/jsp/header.jsp" %>
		
		<div class="container" >
			<div style="width:100%;height:300px; border:3px solid black">
				<center>
					<h1>${msg }</h1>
					<h3><a href="${pageContext.request.contextPath}/index.jsp">返回主页</a></h3>
					<span>
						<h4><a href='#'>qq邮箱</a></h4>
						<h4><a href='#'>163邮箱</a></h4>
					</span>
					
				</center>
			</div>
		</div>
		<br>
		<%@include file="/jsp/footer.jsp" %>

</body>
</html>