<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>房子下面评论</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/authority/bootstrap-combined.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/authority/css/layoutit.css"/>

<script type="text/javascript">
/* 	// 跳到下一页
	function jumpInputPage(hid,pc){
		alert(hid);
		alert(pc);
		$("#submitForm").attr("action","${pageContext.request.contextPath}/comment_findByHouseId?hid="+hid+"&pageCode="+pc).submit();
	} */
</script>


</head>
<body>
<fieldset>
<c:choose>
	<c:when test="${empty pb.beanList }">
		<h1>暂时没有新闻</h1>
	</c:when>
	<c:otherwise>
	  <legend>新闻管理</legend>  
	 	<form class="form-search" id="submitForm" action="${pageContext.request.contextPath }/comment_findByPage" method="post" >
			<input type="hidden" name="hid" value="${hid }"/>
			<input class="input-medium search-query" type="text" name="content" />
		    <button class="btn" type="submit">查找</button>
		</form>
	  <c:forEach  var="bean" items="${pb.beanList}" varStatus="vs">
       <label>新闻名称：${bean.ntitle } &nbsp;发布新闻时间: ${bean.ntime }</label>
       <textarea  rows="4" style="width:700px;" readonly="readonly">${bean.ncontent }</textarea>
       <a href="${pageContext.request.contextPath }/news_deleteByAll?nid=${bean.nid}">删除</a>
       <a href="${pageContext.request.contextPath }/comment_findByPage?nid=${bean.nid}">查看评论</a>
       
      </c:forEach>

  
 <!-- 分页 -->
<div class="ui_flt" style="height: 30px; line-height: 30px;">
	共有<span class="ui_txt_bold04">${pb.totalCount }</span>条记录，
	当前第<span class="ui_txt_bold04">${pb.pageCode }/${pb.totalPage }</span>页
</div>
<div class="ui_frt">
	<c:if test="${pb.pageCode > 1}">
	[<A href="${pageContext.request.contextPath }/news_findByPageAll?pageCode=${pb.pageCode-1}">上一页</A>]
	</c:if>
	<c:if test="${pb.pageCode < pb.totalPage}">
	[<A href="${pageContext.request.contextPath }/news_findByPageAll?pageCode=${pb.pageCode+1}">下一页</A>]
	</c:if>
</div>

</c:otherwise>
</c:choose>
</fieldset>
</body>
</html>
