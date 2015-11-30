<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function showMainView(type){
		var basePath = '${pageContext.request.contextPath}';
		var iframeSrc = '';
		switch(type){
			case 'user':
				iframeSrc = basePath + '/user/queryUsers';
				break;
			case 'dept':
				break;
			default:
				iframeSrc = 'welcome.jsp';
		}
		
		$("#mainFrame").attr("src",iframeSrc);
	}
</script>
</head>
<body>
<div class="container-fluid" id="LG">
	<div class="row-fluid">
		<div class="span2">
			<ul>
				<li>
					<a id="id_List" onclick="showMainView('user');" href="javascript:void(0);">用户管理</a>
				</li>
				<li>
					<a id="id_opticList" onclick="showMainView('dept');"  href="javascript:void(0);">部门管理</a>
				</li>
			</ul>
		</div>
		<div class="span9">
			<iframe id="mainFrame" width="100%" frameborder="0" src="welcome.jsp" ></iframe>
		</div>
	</div>
</div>
</body>
</html>