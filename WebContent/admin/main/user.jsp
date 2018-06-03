<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
<body >
	<div class="panle panel-success">
				<div class="panel-heading">
				<a class="panel-title">用户管理</a>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-hover">
							<thead>
						
								<tr>
									<th>ID</th>
									<th>账号</th>
									<th>姓名</th>
									<th>邮箱</th>
									<th>生日</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="u" varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${u.username }</td>
									<td>${u.name }</td>
									<td>${u.email }</td>
									<td>${u.birthday }</td>
									<td>
										<c:if test="${u.state == 1}">
											已激活
										</c:if>
										<c:if test="${u.state == 0}">
											未激活
										</c:if>
									</td>
									
									<td><button  class="btn deaful-btn-mg"  onclick="mydelete('${u.uid}')">删除</button></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
</body>
<script type="text/javascript">
	
	 function mydelete(uid){
		if(confirm("确认删除吗?")){
			window.location.href="/TTMS/UserServlet?method=deleteUser&uid="+uid;
		}
	}
	 
</script>

</html>