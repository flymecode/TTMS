<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<%@include file="/jsp/header.jsp" %>
		
		
		<!-- 电影信息 -->
		
		<div style="width: 75%; height: 320px; background-color: #413366; margin: 0px auto;border:2px solid;border-radius:8px;">
			<div class="container" style="margin: 10px 30px;">
				<div class="media">
					<div class="media-left">
						<a href="#" style="margin: 10px;">
							<img class="media-object" src="${pageContext.request.contextPath }${movie.mimage }" style="border: 6px solid beige;height:340px">
						</a>
					</div>
					<div class="media-body" style="color: beige;">
						<h3>${movie.mname}</h3>
						喜剧,爱情,奇幻 &nbsp;&nbsp;中国大陆 / ${movie.playtime}分钟   &nbsp;&nbsp; 2018-05-18大陆上映
						<br />
						<h4>电影演员</h4>
						<h5>${movie.actor}</h5>
						<h3>剧情简介</h3>
						<p style="width: 700px;">${movie.mdescription }</p>
					</div>
				</div>	
		 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg" style="position: relative;left:210px;top:10px">宣传片</button>
			</div>
			
		</div>
		<!--
        	作者：offline
        	时间：2018-05-18
        	描述：视频介绍
        -->
	    <!-- Large modal -->
		<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  	<div class="modal-dialog modal-lg" role="document" >
	   	 		<div class="modal-content">
	      			<video src="video/4.mp4" height="500" controls preload="metadata" style="width: 800px; margin: 0 40px;"></video>
	    		</div>
	  		</div>
		</div>
		
		<!--间隔-->
		<div style="height: 150px;"></div>
		
		<!--影厅介绍-->
		<div class="container" id="my">
			<div style="height: 50px; background: ;">
				<span style="line-height: 50px; font-size: 20px;" class="glyphicon glyphicon-search" aria-hidden="true"> 影厅列表</span>
			</div>
			<div>
				<span style="margin-left:50px; font-size: 20px;">放映时间</span>
				<span style="margin-left: 300px; line-height: 50px; font-size: 20px;" >演出厅</span>
				<span style="margin-left:400px; font-size: 20px;"  >售价(元)</span>
				<span style="margin-left:60px; font-size: 20px;"  >选座购票</span>
			</div>
			
			<%-- <div style="height: 75px;">
				<span style="margin-left:50px; font-size: 15px;">放映时间</span>
				<span style="margin-left: 320px; line-height: 50px; font-size: 17px;" >一号厅</span>
				<span style="margin-left:420px; font-size: 15px;" class="glyphicon glyphicon-yen" >${movie.mprice }</span>
				<span style="margin-left:90px; font-size: 15px;"  >
				<a href="#" class="btn  btn-danger">选座购票</a>
				</span>
			</div>	 --%>
			
							
		</div>
		
		
		
		<br /><br /><br />
		<%@include file="/jsp/footer.jsp" %>
</body>
<script type="text/javascript">
	$(function(){
		var url = "/TTMS/ScheduleServlet";
		var params = {"method":"findPlayInfo","mid":${movie.mid}};
		var price = ${movie.mprice};
		$.post(url,params,function(data){
			$.each(data,function(i,obj){
				var my = "<div style='height: 75px;'><span style='margin-left:30px; font-size: 16px;'>"+obj.time+"</span><span style='margin-left: 280px; line-height: 50px; font-size: 18px;' >"+obj.hall.hname+"</span><span style='margin-left:420px; font-size: 15px;' class='glyphicon glyphicon-yen' >"+price+"</span><span style='margin-left:90px; font-size: 15px;'><a href='/TTMS/OrderServlet?mid="+${movie.mid}+"&sid="+obj.sid+"' class='btn  btn-danger'>选座购票</a></span></div>	";
				$("#my").append(my);
			});
		},"json");
	});

</script>
</html>