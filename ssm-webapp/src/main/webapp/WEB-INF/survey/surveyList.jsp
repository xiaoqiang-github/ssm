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
	var ssmModel = {
		ajaxQuery: function(param,url){
			$.ajax({
				url:url,
				type:'get',
				dataType:'json',
				data: param,
				success:function(result){
					display(result.data);
					pageInfo(result);
				},
				error:function(){
					alert('something error!');
				}
		 	});
		}
	};

	function display(data){
		var tableHtml = '<table class="table table-hover">'+
		'<tr>'+
    		'<td><input type="checkbox"/></td>'+
    		'<td>名称</td>'+
    		'<td>开始时间</td>'+
    		'<td>结束时间</td>'+
		'</tr>';
		
		$.each(data,function(i){
			tableHtml += '<tr>';
			tableHtml += '	<td><input type="checkbox" name="surveyId" value="'+data[i].surveyId+'"/></td>';
			tableHtml += '	<td>'+data[i].surveyName+'</td>';
			tableHtml += '	<td>'+data[i].startTime+'</td>';
			tableHtml += '	<td>'+data[i].endTime+'</td>';
			tableHtml += '</tr>';
		});
		
		tableHtml += '</table>';
		$("#tableDiv").html(tableHtml);
	};

	function pageInfo(pageData){
		$("#pageInfo").html('当前第'+ pageData.currentPage +'页&nbsp;&nbsp;共'
	            + pageData.totalPage +'页&nbsp;&nbsp;共'
	            + pageData.totalCount +'条记录');
	}
	 
  	$(document).ready(function(){
  		$("#seachBtn").click(function(){
  			$("#hidden_name").val($("#surveyName").val());
  			
  			var pageData = {
  				"currentPage":1,
  				"pageCount":10,
  				"startRow":0,
  				"endRow":10
  			};

  			var url = '${pageContext.request.contextPath}/survey/ajaxQuery?surveyName='+$("#surveyName").val();
  			ssmModel.ajaxQuery(pageData,url);
  			
  	  	 });

  	});
  	function openAddSurveyLayer(){
  	//iframe层
  		layer.open({
  		    type: 2,
  		    title: '新增问卷',
  		  	shade : [0.2 , '#000' , true],
  		    area: ['700px', '440px'],
  		    content: '${pageContext.request.contextPath}/survey/getSurvey/1' //iframe的url
  		});
	
  	}
  </script>
  <body>
 <div>
  	<input type="text" id="surveyName" name="surveyName"/>
  	<input type="hidden" id="hidden_name">
  	<button id="seachBtn">Search</button>
  	<button onclick="openAddSurveyLayer();" class="btn btn-defaul">Add</button>
    <br/>
    <div id="tableDiv">
	    <table class="table table-hover">
	    	<tr>
	    		<td><input type="checkbox"/></td>
	    		<td>名称</td>
	    		<td>开始时间</td>
	    		<td>结束时间</td>
	    	</tr>
	    	<c:forEach items="${pageData.data}" var="survey">
	    		<tr>
	    			<td><input type="checkbox" name="surveyId" value="${survey.surveyId }"/></td>
	    			<td>
	    			<a href="${pageContext.request.contextPath }/survey/getSurvey/${survey.surveyId}">${survey.surveyName }</a></td>
	    			<td>${survey.startTime }</td>
	    			<td>${survey.endTime }</td>
	    		</tr>
	    	</c:forEach>
	    </table>
    </div>
    <div id="page"></div>
    <div style="clear: both"></div>
    <div id="pageInfo"></div>
    <script type="text/javascript">
    	$(function(){
			$("#page a").css("cursor","pointer");
			$("#pageInfo").html('当前第'+${pageData.currentPage}+'页&nbsp;&nbsp;共'
					            +${pageData.totalPage}+'页&nbsp;&nbsp;共'
					            +${pageData.totalCount}+'条记录');
        });
    	var options = {
			currentPage:${pageData.currentPage},
			totalPages:${pageData.totalPage},
			numberOfPages:10,
			itemContainerClass: function (type, page, current) {
                return (page === current) ? "active" : "pointer-cursor";
            },
			alignment:'left',
			 itemTexts: function (type, page, current) {
	            switch (type) {
	            case "first":
	                return "首页";
	            case "prev":
	                return "上一页";
	            case "next":
	                return "下一页";
	            case "last":
	                return "尾页";
	            case "page":
	                return page;
	            }
	        },
	        onPageClicked: function(e,originalEvent,type,page){
	        	loadData(type,page)
            }
    	};

    	/*
    	type:类型 first,prev,next,last
    	page: 第几页 
    	*/
		function loadData(type,page){
			var ajaxUrl = '${pageContext.request.contextPath}/survey/ajaxQuery?surveyName='+$("#hidden_name").val();
			var pageData = {
	  				"currentPage":page,
	  		};

			ssmModel.ajaxQuery(pageData,ajaxUrl);
    	}

      	 $("#page").bootstrapPaginator(options);
    </script>
  </div>  
    
  </body>
</html>
