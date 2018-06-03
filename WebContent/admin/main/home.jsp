<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
		<!-- 导航栏部分 -->
		<div class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<div class="navbar-brand">
						<small class="glyphicon glyphicon-fire"></small>小黄人影院
					</div>
				</div>
				<ul class="nav navbar-nav nav-stacked navbar-right">
					<!-- <li>
						<a href="#">
							<span class="glyphicon glyphicon-tasks"></span>
							<i class="badge">2</i>
						</a>
					</li>
					<li>
						<a href="#">
							<span class="glyphicon glyphicon-bell"></span>
							<i class="badge">1</i>
						</a>
					</li>
					<li>
						<a href="#">
							<span class="glyphicon glyphicon-envelope"></span>
							<i class="badge">1</i>
						</a>
					</li> -->
					<li>
						<a href="#" data-toggle="dropdown">
							<!--<img class="img-circle" src="#" width="30" height="30" />-->
							<small>Welcome</small> ${admin.name }
							<span class="caret"></span>
						</a>
						<ul class="nav nav-pills nav-stacked dropdown-menu">
							<li class="active">
								<a href="#">
									<span class="glyphicon glyphicon-cog"></span> Setting
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">
									<span class="glyphicon glyphicon-user"></span> Profile
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="${pageContext.request.contextPath }/AdminServlet?method=logOut">
									<span class="glyphicon glyphicon-off"></span> Logout
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>

		<!-- 页面部分 -->
		<div class="row">
			<div class="col-sm-2">
				<div id="search">
					<div class="input-group">
						<input class="form-control input-sm" type="text" />
						<div class="input-group-btn">
							<a href="#" class="btn btn-success btn-sm">
								<span class="glyphicon glyphicon-search"></span>
							</a>
						</div>
					</div>
				</div>

				<div class="panel-group" id="box">
				
					<div class="panel panel-success">
						<div class="panel-heading">
							<a href="#collapseA" data-parent="#box" data-toggle="collapse" class="panel-title">用户管理</a>
						</div>
						<div class="panel-collapse collapse in" id="collapseA">
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
									<li>
										<a href="${pageContext.request.contextPath }/AdminUserServlet?method=findUserWithPage" target="main">用户列表</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-success">
						<div class="panel-heading">
							<a href="#collapseB" data-parent="#box" data-toggle="collapse" class="panel-title">电影管理</a>
						</div>
						<div class="panel-collapse collapse" id="collapseB">
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
									<li>
										<a href="${pageContext.request.contextPath }/AdminMovieServlet?method=findAllMovieWithPage" target="main">电影列表</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath }/AdminMovieServlet?method=addMovieUI" target="main">电影添加</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-success">
						<div class="panel-heading">
							<a href="#collapseC" data-parent="#box" data-toggle="collapse" class="panel-title">订单管理</a>
						</div>
						<div class="panel-collapse collapse in" id="collapseC">
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
									<li>
										<a href="${pageContext.request.contextPath }/AdminOrderServlet?method=findAllOrder" target="main">全部订单</a>
									</li>
									<%-- <li>
										<a href="${pageContext.request.contextPath }/AdminOrderServlet?method=findAllOrder" target="main">未付款订单</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath }/AdminOrderServlet?method=findAllOrder" target="main">已付款订单</a>
									</li> --%>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-success">
						<div class="panel-heading">
							<a href="#collapseD" data-parent="#box" data-toggle="collapse" class="panel-title">演出计划管理</a>
						</div>
						<div class="panel-collapse collapse in" id="collapseD">
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
									<li>
										<a href="${pageContext.request.contextPath }/ScheduleServlet?method=findAllSchedule" target="main">全部演出计划</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath }/ScheduleServlet?method=addScheduleUI" target="main">增加演出计划</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-success">
						<div class="panel-heading">
							<a href="#collapseE" data-parent="#box" data-toggle="collapse" class="panel-title">演出厅管理</a>
						</div>
						<div class="panel-collapse collapse in" id="collapseE">
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
									<li>
										<a href="${pageContext.request.contextPath }/AdminServlet?method=findAllHall" target="main">全部演出厅</a>
										
									</li>
									<li>
										<a href="${pageContext.request.contextPath }/admin/main/addhall.jsp" target="main">添加演出厅</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
				</div>
			</div>

			<div class="col-sm-10">
				<div class="bread-crumb">
					<ul class="breadcrumb">
						<li><span class="glyphicon glyphicon-home"></span>
							<a href="#">Home</a>
						</li>
						<li>
							<a href="#">User</a>
						</li>
						<li>Add</li>
					</ul>
				</div> 
			
				
				<!-- 显示界面 -->
				 <iframe src="admin/main/welcome.jsp" name="main" style="width:100%;height:500px; border: 0px" scrolling="yes">
				 
				 </iframe>
				</div>
			</div>
			<!-- footer -->
			<div class="container">
			<div class="row">
                <div class="col-md-12">
                    <div align="center" style="padding-top: 50px">
                        CopyMX Team © 2017-2018 SuperMan
                    </div>
                </div>
            </div>
        </div>
		
	</body>
</html>