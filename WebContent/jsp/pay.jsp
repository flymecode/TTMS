<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="/jsp/header.jsp" %>
		
		
		<!-- 电影信息 -->
		
		<div style="width: 75%; height: 320px; background-color: #413366; margin: 0px auto;border:2px solid;border-radius:8px;">
			<div class="container" style="margin: 10px 30px;">
				<div class="media">
					<div class="media-left">
						<a href="#" style="margin: 10px;">
							<img class="media-object" src="${pageContext.request.contextPath }${oi.movie.mimage }" style="border: 6px solid beige;height:340px">
						</a>
					</div>
					<div class="media-body" style="color: beige;">
						<h3>${oi.movie.mname}</h3>
						喜剧,爱情,奇幻 &nbsp;&nbsp;中国大陆 / ${oi.movie.playtime}分钟   &nbsp;&nbsp; 2018-05-18大陆上映
						<br />
						<h4>电影演员</h4>
						<h5>${oi.movie.actor}</h5>
						<h3>剧情简介</h3>
						<p style="width: 700px;">${oi.movie.mdescription }</p>
					</div>
				</div>	
			</div>
			<div calss="container">
			<div class="row">
				<form action = "${pageContext.request.contextPath }/OrderServlet?method=payOrder" method="post">
					<h3>信用卡EML</h3><input type="text" />
					<input type="submit" value="确认" />
				</form>
			</div>
			</div>			
		</div>
	
</body>
</html>