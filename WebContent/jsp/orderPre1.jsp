<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/orderPre.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<!-- 引入jQuery-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>购票</title>
		
		
</head>
<body>
	<%@include file="/jsp/header.jsp" %>

	<div id="box">
		<div class="conten">
			<div class="list">
				<span><img src="${pageContext.request.contextPath }/img/chair/white.png" align="middle" style="width: 30px"> 可选座位</span>
				<span><img src="${pageContext.request.contextPath }/img/chair/red.png" align="middle" style="width: 30px"> 已售座位</span>
				<span><img src="${pageContext.request.contextPath }/img/chair/green.png" align="middle" style="width: 30px"> 已选座位</span>
				<span><img src="${pageContext.request.contextPath }/img/chair/love_people.png" align="middle" style="width: 50px"> 情侣座位</span>
			</div>
			<div class="screen">
				<img src="${pageContext.request.contextPath }/img/chair/screen.png">
				<br>
				<span>荧幕中央</span>
			</div>
			<div class="obody">
				<div id="seat">
				<c:forEach begin="1" end="100">
					<img src="${pageContext.request.contextPath }/img/chair/white.png" alt="座位" />
				</c:forEach>
				</div>
				<ul>
					<li>1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li>5</li>
					<li>6</li>
					<li>7</li>
					<li>8</li>
					<li>9</li>
					<li>10</li>
				</ul>
			</div>
		</div>

		<div class="about">
			<div class="more">
				<div class="pic">
					<img src="${pageContext.request.contextPath }/img/chair/union.png" width="120px">
				</div>
				<div class="topic">
					<h3>复仇者联盟3：无限...</h2>
						<div class="text">
						<span>类型：</span>动作，冒险，科幻
						<br>
						<span>时长：</span>150分钟
						</div>
				</div>
			</div>
			<div class="explain">
				<br>

				<span>影院：</span>奥斯卡国际影城
				<br>
				<span>影厅：</span>6号激光厅
				<br>
				<span>版本：</span>英语3D
				<br>
				<span>场次：</span><span class="time">今天5月22 20:30</span>
				<br>
				<span>票价：</span>¥ <span id="price">41</span>/张
			</div>
			<div class="price">
				<span>座位：</span>请<span class="time">点击左侧</span>座位图选择座位
                <div id="message">
                	
                </div>
				<div class="sum" style="margin-top:50px;">
					<p>票数：<span id="num">0</span></p>
					<p>总价：<span class="red">¥<span id="total">0</span></span> </p>
				</div>
			</div>
			<input type="submit" name="buy" value="确认购买" id="buy">
		</div>
	</div>
	
	<br />	<br />
	<%@include file="/jsp/footer.jsp" %>
</body>


<script type="text/javascript">


		window.onload=function(){
		//beginning();
		//这里显示的是其中选的座位的数量
		var num=0;
		var price = parseInt(document.getElementById("price").innerHTML);
		var total = document.getElementById("total");
		var message = document.getElementById("message");
		var number = document.getElementById("num");
        var buy = document.getElementById("buy");
		//这里是显得是对应的其中的修改其中的修改状态的
		var seat = document.getElementById('seat').getElementsByTagName('img');
		for (var i = 0; i <=seat.length - 1; i++) {
			seat[i].seatBtn=true;
			seat[i].index=i;
			seat[i].onclick=function(){
				if(this.seatBtn){
					this.setAttribute("src","../img/chair/green.png");
					num++;
					if(num>6){
						alert("您最多只能买6张");
			            this.setAttribute("src","../img/chair/white.png");
			            total.innerHTML=6*price;
			            return ;
					}
					this.seatBtn=false;
					information(this.index+1,message);
				}
				else{
					this.setAttribute("src","../img/chair/white.png");
					delectMessage(this.index+1,message);
					num--;
					this.seatBtn=true;
				}
				total.innerHTML=num*price;
				number.innerHTML=num;
			}
		}
		
		
		
		
		//这里实现的就是其中的传递数据的
		buy.onclick=function(){
			var data=[];
            var information = message.getElementsByTagName("p");
            var total = document.getElementById("total").value;
            for (var i = information.length - 1; i >= 0; i--) {
            	data.push[information[i].innerHTML.substring(0,1)];
            	data.push[information[i].innerHTML.substring(2,3)];
            }
            alert(total);
			loadXMLDoc({"data":data,"total":total});
		}
	}

	

   //这个是对应的增加其中的信息
	function information(i,parent){
		var row=(parseInt(i/10))+1;
		var col = i%10;
		if(col==0) col=10;
        var p = document.createElement('p');
        p.innerHTML=row+"排"+col+"座";
        p.style.float="left";
        p.style.margin="10px";
        p.style.backgroundColor ="gray";
        p.style.padding="5px";
        p.style.borderRadius="5px";
        parent.appendChild(p);
	}

	//这里实现的其中的删除的信息
	function delectMessage(i,parent){
       var information = parent.getElementsByTagName("p");
       for (var i = 0; i <=information.length - 1; i++) {
       	   parent.removeChild(information[i]);
       }

	}

	//这里实现的是其中的传递数据的
	function loadXMLDoc(obj)
	{
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp=new XMLHttpRequest();
		}
		else
		{
			// IE6, IE5 浏览器执行代码
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				//alert("恭喜你，买票成功");
			}
		}
		xmlhttp.open("POST","/TTMS/OrderServlet?method=submitOrder",true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send(obj);
	}


	function beginning()
	{
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp=new XMLHttpRequest();
		}
		else
		{
			// IE6, IE5 浏览器执行代码
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				console.log(XMLHttpRequest);
				var data=JSON.parse(XMLHttpRequest);
				for(var i = 0; i <=data.length - 1; i++) {
					var row = data[i].row;
					var cols = data[i].column;
					var number = (parseInt(row))*10+parseInt(cols);
					var seat = document.getElementById("seat").getElementsByTagName("img");
					seat[number].setAttribute("src","../img/chair/red.png");
				}
			}
		}
		
    
		xmlhttp.open("POST","/TTMS/TestServlet",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("method=isSelect&hid=1");
	}
</script>
		

</html>	
	
	

	