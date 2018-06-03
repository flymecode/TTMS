<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>苍穹电影院</title>

		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="js/bootstrap.js"></script>
		

		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
		<%@include file="/jsp/header.jsp" %>
		
		
		<!--轮播图-->
		
		<div class="container" >
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="5000" >
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>
			
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox" >
					<div class="item active">
						<img src="img/index1.jpg" alt="..."  style="height:500px; width:100%">
					</div>
					<div class="item">
						<img src="img/index2.jpg" alt="..." style="height:500px;width :100%">
					</div>
					<div class="item">
						<img src="img/index3.jpg" alt="..." style="height:500px;width :100%">
					</div>
				</div>
				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		
		
		
		
		<!--正在上映-->
		
		<div class="container">
			<div>
				<h3>正在上映</h3>
					<!--清除浮动-->
				<div class="clearfix"></div>
				<a href="/TTMS/MovieServlet?method=findListMovieWithPage&cid=1&num=0"><h4>更多影片</h4></a>
			</div>
				
					<div class="row">
					 <c:forEach items="${play }" var="p">
					  	<div class="col-xs-6 col-md-2">
					    	<a href="${pageContext.request.contextPath }/MovieServlet?method=findMovieById&mid=${p.mid}" class="thumbnail">
					     		<img src="${pageContext.request.contextPath }${p.mimage }" style="width:400px;height:280px">
					     		<span style="font-size: 20px;text-align: center;line-height: 40px; font-family: "微软雅黑";" class="pull-left">${p.mname }</span>
					    	</a>
					  	</div>
					  </c:forEach>
					</div>
			</div>
		
		<!--即将上映-->
		<div class="container">
			<div>
				<h3>即将上映</h3>
					<!--清除浮动-->
				<div class="clearfix"></div>
				<a href="/TTMS/MovieServlet?method=findListMovieWithPage&cid=2&num=0"><h4>更多影片</h4></a>
			</div>
			<div class="row">
			  	
			  	<c:forEach items="${com }" var="c">
			  		<div class="col-xs-6 col-md-2">
			     		<a href="${pageContext.request.contextPath }/MovieServlet?method=findMovieById&mid=${c.mid}" class="thumbnail">
			     			<img src="${pageContext.request.contextPath }${c.mimage }" style="width:410px;height:280px">
			     			<span style="font-size: 20px;text-align: center;line-height: 40px; font-family: "微软雅黑";" class="pull-left">${c.mname }</span>
			     		</a>
			     		
			  		</div>
			  	</c:forEach>
			</div>
		</div>
		
		<br /><br />
		<%@include file="/jsp/footer.jsp" %>
	</body>
</html>