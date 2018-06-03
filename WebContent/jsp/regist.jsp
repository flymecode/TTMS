<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	
		
		<%@include file="/jsp/header.jsp" %>
		
		<!--注册页面-->
		<div class="container">  
  
        <div class="form row" style="background-image: url(${pageContext.request.contextPath}/img/h3.jpg); height:800px;">  
        
            <form action="${pageContext.request.contextPath}/UserServlet?method=userRegist" class="form-horizontal col-sm-offset-8 col-md-offset-8" id="register_form" method="post"  onsubmit="return checkregist()">  
                <h3 class="form-title">Regist to your account</h3>  
                	<div class="col-sm-9 col-md-9"> 
                	 	<div class="form-group">  
                       		 <i class="fa fa-user fa-lg"></i>  
                       		 <input class="form-control required" type="text" id ="name" placeholder="Name" name="name" autofocus="autofocus"/> 
                       		 <span id="namespan"></span> 
                   		</div> 
		                <div class="form-group">  
		                    <i class="fa fa-user fa-lg"></i>  
		                    <input class="form-control required" type="text" placeholder="Username" name="username" id="username" autofocus="autofocus"/>  
		                    <span id="usernamespan"></span>
		                </div>  
		                <div class="form-group">  
		                    <i class="fa fa-lock fa-lg"></i>  
		                    <input class="form-control required" type="password" placeholder="Password"  id="password" name="password"/>  
		                    <span id="passwordspan"></span>
		                </div>  
		                 <div class="form-group">  
		                    <i class="fa fa-check fa-lg"></i>  
		                    <input class="form-control required" type="password" placeholder="Repeate Your Password" id="re_password" name="rpassword"/>  
		                    <span id="re_passwordspan"></span>
		                </div>  
		               <div class="form-group">
							<i class="fa fa-envelope fa-lg"></i>
							<input class="form-control eamil" type="text" placeholder="Email" name="email" id="email" />
							<span id="emailspan"></span>
						</div>
						
						<div class="form-group">
							<i class="fa fa-user fa-lg"></i>
							<input class="form-control required" type="date" name="birthday" autofocus="autofocus" id="birthday" />
							<span id="birthdayspan"></span>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-success pull-right" value="Regist " />
							<span id="namespan"></span>
							<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-info pull-left" role="button">Back</a>
						</div>
                	</div>  
           		 </form>
            </div>
         </div> 
		<hr width="75%" />
		<%@include file="footer.jsp" %>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jiaoyan.js"></script>
</html>