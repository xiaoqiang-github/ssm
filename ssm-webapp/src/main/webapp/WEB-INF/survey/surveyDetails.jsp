<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  </script>
<body>
	<div>
	    <table class="table table-hover">
	   		 <caption>${survey.surveyName }</caption>
	    	<tr>
	    		<th>题目名称</th>
	    	</tr>
	    	<c:forEach items="${survey.opticList }" var="optic" varStatus="status">
	    		<tr>
	    			<td>
	    				${status.index+1}. ${optic.opticName }(${optic.opticWeight})分<br><br>
		    			<c:forEach items="${optic.optionList }" var="option">
				    			<input type="radio">${option.optionName }(${option.optionWeight*optic.opticWeight })分 &nbsp;
		    			</c:forEach>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </table>
	</div>  
</body>
</html>
