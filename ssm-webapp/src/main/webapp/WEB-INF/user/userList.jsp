<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>

<table class="table table-hover">
	<tr>
		<th>名称</th>
		<th>昵称</th>
		<th>性别</th>
		<th>生日</th>
		<th>部门</th>
	</tr>
	<c:forEach items="${userList }" var="user">
		<tr>
			<td>${user.userName }</td>
			<td>${user.nickName }</td>
			<td>${user.sex == 1?'男':'女' }</td>
			<td>${user.birthday }</td>
			<td>${user.dept.deptName }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>