<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/login/login.css" type="text/css"></link></head>

<script type="text/javascript">
	function login(){
		var checked = true;
		$("span").each(function(){
			$(this).text("");
		});
		
		var name = $("#userName").val();
		var password = $("#passWord").val();
		if(!name){
			$("#userName").next("span").text('请输入用户名');
			checked = false;
		}

		if(!password){
			$("#passWord").next("span").text('请输入密码');
			checked = false;
		}
		
		if(checked){
			$.ajax({
				url:'${pageContext.request.contextPath}/user/login',
				type:'post',
				dataType:'json',
				async:false,
				data:{
					userName:name,
					passWord:password
				},
				success:function(data){
					console.info(data);
					if(data.flag){
						window.location.href="${pageContext.request.contextPath}/user/queryUsers";
					}else{
						alert(data.message);
					}
				},
				error:function(e){
					alert("出错了!"+e);	
					console.info(e);
				}
			});
		}
	}
</script>
<body>
<div class="container">
      <form id="form" class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading">登陆</h2>
        <input type="text" id="userName" name="userName" class="form-control" placeholder="用户名" required autofocus><span style="color:red"></span>
        <input type="password" id="passWord" name="passWord" class="form-control" placeholder="密码" required><span style="color:red"></span>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住我
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login();">登录</button>
      </form>
</div>
</body>
</html>