var nameflag = true;
var usernameflag = true;
var passwordflag = true;
var emailflag = true;
var repassword = true;

$(function() {
	$("#name").blur(function() {

		var name = $("#name").val();
		if (name.length < 2 || name.length > 12) {
			$("#namespan").html("姓名大于2位且小于12位").css("color", "red");
			nameflag = false;
		} else {
			$("#namespan").html("姓名可用").css("color", "green");
			nameflag = true;
		}
	});
	$("#username").focus(function() {
		$("#usernamespan").html("");
	})

	$("#username").blur(function() {//对于用户名的判断
		var username = $("#username").val();
		var userzheng = /^[A-Za-z]+[A-Za-z0-9]+$/;
		var retuendata;

		if (username.length < 5 || !userzheng.test(username)) {
			$("#usernamespan").html("账户大于5位且以首字母开头").css("color", "red");
			usernameflag = false;
		} else {
			$.post("/TTMS/UserServlet?method=checkUserName", {
				"username" : username
			}, function(data) {
				returndata = data;

			}, "json");
			if (returndata.data == "满足要求") {
				usernameflag = true;
				$("#usernamespan").html(returndata.data).css("color", "green");
			} else {
				usernameflag = false;
				$("#usernamespan").html(returndata.data).css("color", "red");
			}

		}
	});

	$("#password").blur(function() {
		var password = $("#password").val();
		if (password.length >= 5) {
			$("#passwordspan").html("密码满足要求").css("color", "green");
			passwordflag = true;
		} else {
			$("#passwordspan").html("密码大于5位").css("color", "red");
			passwordflag = false;
		}
	});

	$("#re_password").blur(function() {
		var password = $("#password").val();
		var re_password = $("#re_password").val();
		
		if (password == re_password) {
			$("#re_passwordspan").html("两次一致").css("color", "green");
		} else {
			$("#re_passwordspan").html("两次密码不一致").css("color", "red");
			repassword = false;
		}
	});

	$("#email").blur(function() {//邮箱校验
		var email = $("#email").val();
		var emailzheng = /^\w{3,}@\w+(\.\w+)+$/;
		if (emailzheng.test(email)) {
			$("#emailspan").html("邮箱格式正确").css("color", "green");
			emailflag = true;
		} else {
			$("#emailspan").html("邮箱格式错误").css("color", "red");
			emailflag = false;
		}

	});

});

$("#email").focus(function() {
	$("#emailspan").html("");
});

function checkregist() {

	if (nameflag== true && usernameflag==true && passwordflag==true && emailflag==true && repassword==true) {
		return true;
	} else {
		alert("输入格式有错误,请重新输入!");
		return false;
	}

}
