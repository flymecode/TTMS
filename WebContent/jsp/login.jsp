<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>登陆界面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css" />

</head>
<body>
	<%@include file="/jsp/header.jsp"%>
	
	<!-- 登陆界面 -->
	 <div class="container" id="dong">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">LOGIN</h3>   
                <div style="color:red;">${msg }</div>
                <div class="col-md-9">
                	<form action="${pageContext.request.contextPath}/UserServlet?method=userLogin" method="post">
	                    <div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20"/>
	                    </div>
	                    <div class="form-group">
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input  class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
	                    </div>
	                    <div class="form-group">
	                        <label class="checkbox">
	                            <input type="checkbox" name="remember" value="on">记住我
	                        </label>
	                    </div>
	                    <div class="form-group col-md-offset-9">
	                        <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
	<%@include file="footer.jsp" %>
</body>
</html>