<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!--LOGO-->
		<div class="container">
		
			<div class="row">
				<div class="col-md-8">
					<div class="page-header">
						<h1>MyPlay
						<c:if test="${not empty userLogin }">
							<small>&nbsp;&nbsp;&nbsp;Welcome ${userLogin.name }</small>
						</c:if>
						</h1> 
					</div> 
				</div>
			</div>
		</div>
		
		<!--导航条 -->
		<div class="container">	
			<nav class="navbar navbar-inverse" role="navigation">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					 	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	       					<span class="sr-only">Toggle navigation</span>
						    <span class="icon-bar"></span>
						    <span class="icon-bar"></span>
						    <span class="icon-bar"></span>
					    </button>
					
						<a class="navbar-brand active" href="${pageContext.request.contextPath }/index.jsp"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span><span class="sr-only">(current)</span>首页</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav" id="my_UL">
							<%-- <li>
								<a href="${pageContext.request.contextPath }/MovieServlet?method=listMovieUI">正在上映 </a>
							</li> --%>
							<%-- <li>
								<a href="${pageContext.request.contextPath }/MovieServlet?method=listMovieUI">即将上映 </a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/MovieServlet?method=listMovieUI">热播影片 </a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/MovieServlet?method=listMovieUI">经典影片</a>
							</li> --%>
							<%-- <li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">全部分类 <span class="caret"></span></a>
						          <ul class="dropdown-menu">
						            <li><a href="${pageContext.request.contextPath }/MovieServlet?method=listMovieUI">动画片</a></li>
						            <li><a href="#">动画片</a></li>
						            <li><a href="#">动画片</a></li>
						            <li role="separator" class="divider"></li>
						            <li><a href="#">动画片</a></li>
						            <li role="separator" class="divider"></li>
						            <li><a href="#">动画片</a></li>
						          </ul>
       						</li> --%>
						</ul>

						<form class="navbar-form navbar-right"  method="post" action="${pageContext.request.contextPath }/MovieServlet?method=findMovieByName">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search Movie" name="search">
							</div>
							<%-- <a type="button" class="btn btn-default" href="${pageContext.request.contextPath }/MovieServlet?method=findMovieByName&search=飞龙在天">查询</a> --%>
						<button type="submit" class="btn btn-default">查询</button>
							
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<c:if test="${empty userLogin }"> 
					  		  	请登陆 
					  		 </c:if>
					  		 <c:if test="${not empty userLogin }"> 
					  		  	Welcome
					  		 </c:if>	
					  		<span class="caret"></span>
					  		</button>
					  		<ul class="dropdown-menu">
					  		<c:if test="${empty userLogin }">
					  			<li><a href="${pageContext.request.contextPath }/UserServlet?method=userLoginUI"><span class="glyphicon glyphicon-user"></span>登陆</a></li>
					  			<li><a href="${pageContext.request.contextPath }/UserServlet?method=userRegistUI"><span class="glyphicon glyphicon-cog"></span>注册</a></li>
					  		</c:if>
					  		<c:if test="${not empty userLogin }">
					  			<li><a href="${pageContext.request.contextPath }/UserServlet?method=userOut"><span class="glyphicon glyphicon-off"></span>退出</a></li>
					   		 	<li><a href="#"  data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span>个人信息</a></li>
					   		 	<li><a href="${pageContext.request.contextPath }/OrderServlet?method=findOrderByUid&uid=${userLogin.uid}"><span class="glyphicon glyphicon-shopping-cart"></span>我的订单</a></li>
					   		 </c:if>	
					 		</ul>
						</form>
					</div>
				</div>
			</nav>
		</div>
		
		
		
		<!-- 个人信息展示 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">个人信息</h4>
					</div>
					
					
					<div class="modal-body">
						<h5>用户名:${sessionScope.userLogin.username}</h5>
						<h5>姓名：${sessionScope.userLogin.name }</h5>
						<h5>生日：${sessionScope.userLogin.birthday }</h5>
					</div>
							
				</div>
							
				<div class="modal-footer">
					<a type="button"  class="btn btn-default"  href="${pageContext.request.contextPath }/UserServlet?method=updateUserInfoUI">修改</a>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
		
		
</body>
<!-- 引入jQuery-->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$(function(){
		
		var url ="/TTMS/CategoryServlet";
		var params = {"method":"findAllMovieCats"}
		$.post(url,params,function(data){
			$.each(data,function(i,obj){
				var li = "<li><a href='/TTMS/MovieServlet?method=findListMovieWithPage&cid="+obj.cid+"&num=0'>"+obj.cname+"</a></li>";
				$("#my_UL").append(li);
			});
		},"json");
	});
</script>
</html>