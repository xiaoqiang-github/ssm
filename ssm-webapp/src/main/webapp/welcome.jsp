<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="scripts/zTree/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="scripts/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
	var zTreeObj;
	var zTreeNodes;
	var setting = {
		check:{
			enable:true
		},
		callback:{
			onClick:zTreeOnClick
		},
		view:{
			selectedMulti:false
		},
		data:{
			simpleData:{
				enable: true,
				idKey: "deptId",
				pIdKey: "parentId",
				rootPId: 1
			},
			key: {
				name: "deptName"
			}
		}
	};
	
	function zTreeOnClick(event, treeId, treeNode) {
	    alert(treeNode.deptId + ", " + treeNode.deptName);
	};
	
	$(document).ready(function(){
		$.ajax({
			url:'${pageContext.request.contextPath}/dept/loadDeptTree',
			type:'get',
			dataType:'json',
			async:false,
			success: function(data){
				zTreeNodes = data;
				console.info(data);
			}
			
		});
		zTreeObj = $.fn.zTree.init($("#tree"), setting, zTreeNodes);
	});
	
	
	
	
</script>
</head>
<body>
<div class="container">
	欢迎进入系统！
	<hr>
	
	<div id="tree" class="ztree" style="width:230px; overflow:auto;"></div>
</div>
</body>
</html>