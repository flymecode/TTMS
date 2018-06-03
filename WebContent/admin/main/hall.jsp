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
				<a class="panel-title">演出厅信息</a>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>演出厅id</th>
									<th>演出厅名字</th>
									<th>演出厅描述</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${halllist}" var="u" varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${u.hname }</td>
									<td>${u.hdescription }</td>
									<td><button  class="btn deaful-btn-mg" class="mybutton" onclick="mydelete('${u.hid }')">删除</button></td>
									<td><button  class="btn deaful-btn-mg" class="mybutton" onclick="myupdata('${u.hid }')" >修改</button></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
</body>
<script type="text/javascript">
function mydelete(hid){
	if(confirm("确认删除吗?")){
		window.location.href="/TTMS/AdminServlet?method=deleteHall&hid="+hid;
		alert("删除成功");
	}
}
 
 function myupdata(hid){
		if(confirm("确认修改吗?")){
			window.location.href="/TTMS/AdminServlet?method=updataHallUI&hid="+hid;
			
		}
	}
</script>
</html>