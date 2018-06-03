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

	<%@include file="/jsp/header.jsp" %>
	<!-- 我的订单 -->
	<div calss="container">
			<div style="border: 3px solid; margin: 10px 200px;">
			<table class="table" style="margin: 1px 1px;">
				<tr >
					<th>订单编号</th>
					<th>订单时间</th>
					<th>订单状态</th>
					<th>订单总价</th>
					
				</tr>
				<c:forEach items="${list}" var="order">
				<tr>
					<td>${order.oid }</td>
					<td>${order.orderTime }</td>
					<c:if test="${order.state ==1 }">
						<td>已付款</td>
					</c:if>
					<c:if test="${order.state ==0 }">
						<td>未付款</td>
					</c:if>
					
					<td>${order.total}</td>
					<td>
						<button class="btn btn-info pull-left"  data-toggle="modal" data-target="#myModal3" onclick="findOrderItem('${order.oid }')">查看订单详情</button>
					</td>
					<td>
						<button class="btn btn-info pull-left"   onclick="payOrder('${order.oid }')">付款</button>
					</td>
				</tr>
				</c:forEach>
				</table>
			</div>
			</div>
			
				<!-- 订单的详细信息 -->
			<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
			
				<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">订单详情</h4>
					</div>
				<div class="modal-body">
				<table class="table"  id="mytable" style="vertical-align: middle; text-align: center;">
				
				</table>
				
				</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
				</div>
		</div>
		<br>
		
		<%@include file="/jsp/footer.jsp" %>
		<script type="text/javascript">
		
			function findOrderItem(oid){
				$("#mytable").empty();
				var header = "<tr><td><h4>电影名称</h4></td><td><h4>电影票数量</h4></td><td><h4>演出厅</h4></td><td><h4>播放时间</h4></td><td></td><tr>";
				$("#mytable").append(header);
				var url = "/TTMS/OrderServlet";
				var params = {"oid":oid,"method":"findOrderByOid"};
				$.post(url,params,function(data){
					$.each(data,function(i,obj){
						var li = "<tr><td>"+obj.movie.mname+"</td><td>"+obj.num+"</td><td>"+obj.hname+"</td><td>"+obj.time+"</td><td><a class='btn btn-info pull-left' href='/TTMS/OrderServlet?method=deleteOrder&oid="+oid+"' >取消订单</a></td></tr>";
						$("#mytable").append(li);
					});
				},"json");
			}	
			
			
			function payOrder(oid){
				
				window.location.href="OrderServlet?method=payOrderUI&oid="+oid;
				
			}
		</script>
</body>
</html>