<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		<title>更新个人信息</title>

</head>
<body>
	<%@include file="/jsp/header.jsp" %>
	<div class="container"> 
		<div  class="form row" style="background-image: url(${pageContext.request.contextPath}/img/timg.jpg); height:800px;"">
			<form class="form-horizontal col-sm-offset-8 col-md-offset-8" id="register_form" action="${pageContext.request.contextPath}/UserServlet?method=updateUserInfo" method="post" onsubmit="return checkregist()">  
	                <h3 class="form-title">Update  your information</h3>  
	                	<div class="col-sm-9 col-md-9"> 
	                	 	<div class="form-group">  
	                       		 <i class="fa fa-user fa-lg"></i>  
	                       		 <input class="form-control required" type="text" placeholder="Name" value="${sessionScope.userLogin.name}" name="name" autofocus="autofocus"/>  
	                       		 <span id="namespan"></span><br> 
	                   		</div> 
			                <div class="form-group">  
			                    <i class="fa fa-lock fa-lg"></i>  
			                    <input class="form-control required" type="password" placeholder="Password" id="register_password" name="password"/>  
			                    <span id="passwordspan"></span>
			                </div>  
			               <div class="form-group">
								<i class="fa fa-envelope fa-lg"></i>
								<input class="form-control eamil" type="text" placeholder="Email" name="email" value="${sessionScope.userLogin.email}"/>
								<span id="emailspan"></span>
							</div>
							
							<div class="form-group">
								<i class="fa fa-user fa-lg"></i>
								<input class="form-control required" type="date" placeholder="" name="birthday" autofocus="autofocus" value="${sessionScope.userLogin.birthday}" />
								<span id="birthdayspan"></span>
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-success pull-right" value="Submit " />
								<a href="${pageContext.request.contextPath }/index.jsp" class="btn btn-info pull-left" role="button">Back</a>
							</div>
	                	</div>  
	            </form>
	         </div>
		</div>
		<hr width="75%"/>
		<%@include file="/jsp/footer.jsp" %>
		
		
</body>
	
</html>