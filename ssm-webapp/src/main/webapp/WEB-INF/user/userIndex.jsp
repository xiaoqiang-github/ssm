<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springmvc 数组测试</title>
<script type="text/javascript">
		function sendArr(){
			var url = '${pageContext.request.contextPath}/user/userIdArr.action';
			var userIds = new Array();
			userIds.push('1abc');			
			userIds.push('2abc');			
			userIds.push('3abc');
			console.info(userIds);
			$.ajax({
				url:url,
				data:{
					userIds: userIds
				},
				success:function(data){
					
				}
			});
		}
		
		function sendList(){
			var url = '${pageContext.request.contextPath}/user/userList.action';
			var userList = new Array();//Json对象数组
			
			var obj1 = {};//单个json对象
			obj1.userName='A1';
			obj1.passWord='123456';
			var obj2 = {};
			obj2.userName='A2';
			obj2.passWord='654321';
			
			userList.push(obj1);
			userList.push(obj2);
			
			console.info(JSON.stringify(userList));
			
			$.ajax({
				url:url+"?objId=22222",
				type:"POST",
				contentType:'application/json',
				data:JSON.stringify(userList),
				success:function(data){
					
				}
			});
		}
</script>
</head>
<body>

<button value="发送数组" onclick="sendArr();">发送数组</button> &nbsp;&nbsp;&nbsp;
<button value="发送list" onclick="sendList();">发送list</button>

</body>
</html>