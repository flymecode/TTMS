<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

	<div class="panle panel-success">
				<div class="panel-heading">
				<a class="panel-title">全部演出计划</a>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>电影</th>
									<th>电影厅</th>
									<th>播放时间</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="s" varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${s.movie.mname }</td>
									<td>${s.hall.hname }</td>
									<td>${s.time}</td>
									<td><button  class="btn deaful-btn-mg" class="mybutton" onclick="mydelete(${u.mid })">删除</button></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
</body>
</html>