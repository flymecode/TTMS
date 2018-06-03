<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="panle panel-success">
				<div class="panel-heading">
				<a class="panel-title">添加演出计划</a>
					</div>
		<form action="${pageContext.request.contextPath }/ScheduleServlet?method=addSchedule" method="post" >
		<table class="table">
				<tr>
					<td><h4>电影名称</h4></td>
					<td>
						<select name="mid">
						<option>-请选择电影-</option>
							<c:forEach items="${list}" var="m">
								<option value="${m.mid }">${m.mname }</option>
							</c:forEach>	
						</select>
					</td>
				</tr>
				<tr>
					<td><h4>电影厅</h4></td>
					<td>
						<select name="hid">
						<option>-请选择电影厅-</option>
							<c:forEach items="${hlist}" var="h">
								<option value="${h.hid }">${h.hname }</option>
							</c:forEach>	
						</select>
					</td>
				</tr>
				<tr>
					<td><h4>播放时间</h4></td>
					<td><input type="datetime-local" name="time"></td>
				</tr>
				<tr>
					<td><input type="reset" value="重置" class="btn btn-info"></td>
					<td><input type="submit" value="确认" class="btn btn-info"></td>
				</tr>
		</table>				
		</form>
	</div>
		</div>
</body>
</html>