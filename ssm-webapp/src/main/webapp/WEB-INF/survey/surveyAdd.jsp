<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <script type="text/javascript">
	$(function(){
		$("#startTime").datetimepicker({
			format:'yyyy-mm-dd',
			autoclose: true,
	        todayBtn: 'linked',
	        minView: 2,
	        language: 'zh-CN'
	  	});
	  	$("#endTime").datetimepicker({
	  		format:'yyyy-mm-dd',
	  		autoclose: true,
	        todayBtn: 'linked',
	        minView: 2,
	        language: 'zh-CN'
	  	});
	});
  </script>
  <body>
    <form action="${pageContext.request.contextPath }/survey/surveyAdd" method="post">
    	<table>
    		<tr>
    			<td>名称</td>
    			<td>
    				<input type="text" name="surveyName">
    			</td>
    		</tr>
    		<tr>
    			<td>开始时间</td>
    			<td>
    				<input type="text" id="startTime" name="startTime">
    			</td>
    		</tr>
    		<tr>
    			<td>结束时间</td>
    			<td>
    				<input type="text" id="endTime" name="endTime">
    			</td>
    		</tr>
    		
    		<tr>
    			<td>说明</td>
    			<td>
    				<input type="text" name="memo"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="submit" id="addSurvey"></button>
    				<input type="reset" id="resetSurvey"></button>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
