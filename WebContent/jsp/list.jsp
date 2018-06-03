<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="js/bootstrap.js"></script>
		

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>电影列表</title>
</head>
<body>
		<%@include file="/jsp/header.jsp"%>
		<!--电影列表-->
		<div class="container">
			<!--第一行-->
			<c:forEach items="${page.list }" var="c">
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail">
					<a href="MovieServlet?method=findMovieById&mid=${c.mid}">
					
						<img src="${pageContext.request.contextPath }${c.mimage}" style="height:300px">
					</a>
					
					<div class="caption">
						<h3>${c.mname } <span style="color: gold;">8.9</span></h3>
						<p>
							<span style="position: relative; left: 150px;"><a href="MovieServlet?method=findMovieById&mid=${c.mid}" class="btn btn-primary" role="button">购票</a></span>	
						</p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		<br />
		<!--分页-->
			<div class=""container>
				<div id="" style="text-align: center;">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li>
							<a href="${pageContext.request.contextPath}/${page.url}&num=${page.prePageNum-1}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<%--显示的页码，使用forEach遍历显示的页面 --%>
    					<c:forEach begin="${page.startPage}" end="${page.endPage}" var="pagenum">
    						<li>
    							<a href="${pageContext.request.contextPath}/${page.url}&num=${pagenum-1}">${pagenum}</a>
    						</li>
    					</c:forEach>						
						<li>
							<a href="${pageContext.request.contextPath}/${page.url}&num=${page.nextPageNum-1}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
				</nav>
				
			</div>
		</div>	
		
		
		<br /><br />
		<%@include file="/jsp/footer.jsp" %>
			
</body>
</html>