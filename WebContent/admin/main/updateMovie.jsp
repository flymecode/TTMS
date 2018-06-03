<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="container">
		<form action="/TTMS/AdminServlet?method=updataHall" method="post" >
		<table class="table">
				<tr>
					<td><h4>电影名称</h4></td>
					<td><input type="text" name="hname" id="hname" value="${movie.mname }"></td>
				</tr>
				<tr>
					<td><h4>电影价格</h4></td>
					<td><input type="number" name="mprice" value="${movie.mprice }"></td>
				</tr>
				<tr>
					<td><h4>电影描述</h4></td>
					<td><textarea name="mdescription" style="margin: 0px; width: 500px; height: 144px;" >${movie.mdescription }</textarea> </td>
				</tr>
				<tr>
					<td><h4>电影播放时间</h4></td>
					<td><input type="number" name="playtime" style="width:100px" value="${movie.playtime }"></td>
				</tr>
				<tr>
					<td><h4>电影演员</h4></td>
					<td><input type="text" name="actor" value="${movie.actor }"></td>
				</tr>
					<td><input type="reset" value="重置" class="btn btn-info"></td>
					<td><input type="submit" value="确认" class="btn btn-info" onclick="update()"></td>
				</tr>
		</table>						
		</form>
	</div>
	<script type="text/javascript">
	
	function update(){
		alert("修改成功");
	}
	</script>
</body>
</html>