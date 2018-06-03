<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
</head>
<body >
	<div class="panle panel-success">
				<div class="panel-heading">
				<a class="panel-title">电影管理</a>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Description</th>
									<th>Image</th>
									<th>Playtime</th>
									<th>Price</th>
									<th>Actor</th>
									<th>Hot(Yes/No)</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="u" varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${u.mname }</td>
									<td>${u.mdescription }</td>
									<td>
										<img src = "${pageContext.request.contextPath }${u.mimage }"/ style="width:90px;height:80px">
									</td>
									<td>${u.playtime }分钟</td>
									<td>${u.mprice }</td>
									<td>${u.actor }</td>
									
									<td>
										<c:if test="${u.mstate ==1 }">
											Yes
										</c:if>
										<c:if test="${u.mstate ==0 }">
											No
										</c:if>
									</td>
									<td><button  class="btn deaful-btn-mg" class="mybutton" onclick="mydelete(${u.mid })">删除</button></td>
									<td><button  class="btn deaful-btn-mg" class="mybutton" onclick="myupdate(${u.mid })">修改</button></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
</body>
<script type="text/javascript">
	 function mydelete(mid){
		if(confirm("确认删除吗?")){
			window.location.href="/TTMS/AdminMovieServlet?method=deleteMovie&mid="+mid;
		}
	}
	 
	 function myupdate(mid){
			if(confirm("确认修改吗?")){
				window.location.href="/TTMS/AdminMovieServlet?method=updateMovieUI&mid="+mid;
			}
		}
</script>
</html>