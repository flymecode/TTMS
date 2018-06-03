<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<title>后台管理</title>
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet" type="text/css" />
<body>
	<div class="login_box">
      <div class="login_l_img"><img src="${pageContext.request.contextPath }/img/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="${pageContext.request.contextPath }/img/login_logo.png" /></a></div>
          <div class="login_name">
               <p>后台管理系统</p>
          </div>
          	<form method="post" action="${pageContext.request.contextPath }/AdminServlet?method=adminLogin" method="post">
            	<input name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
            	<span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
				<input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
            	<input value="登录" style="width:100%;" type="submit">
         	 </form>
      </div>
      <div class="copyright">某某有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
</div>
</body>
</html>