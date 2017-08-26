<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<title>信息管理系统</title>
<script type="text/javascript">
	/** 删除 **/
	function del(uid){
		// 非空判断
		if(uid == '') return;
		if(confirm("您确定要删除吗？")){
			$("#submitForm").attr("action", "${pageContext.request.contextPath}/user_delete.action?uid=" + uid).submit();			
		}
	}
	
	/* 跳转到编辑页面 */
	function to_editUI(uid){
		if(confirm("您确定要修改吗")){
			$("#submitForm").attr("action","${pageContext.request.contextPath }/user_editUI.action?uid=" + uid).submit();
		}
	}
	/* 检索 */	
	function search(){
		$("#submitForm").attr("action","${pageContext.request.contextPath}/user_findByName.action").submit();
	}
	
	/* 翻页 */
	function jumpInputPage(pageCode){
		$("#submitForm").attr("action","${pageContext.request.contextPath}/user_findByPage?pageCode=" + pageCode).submit();
	}
</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_bottom" style="margin-right: 500px">
							姓名：<input type="text"  name="username" class="ui_input_txt02"/>
							
							<input type="button" value="查询" class="ui_input_btn01" onclick="search();" /> 
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
                            <th>ID</th>
							<th>用户名</th>
							<th>密码</th>
							<th>微信号码</th>
							<th>手机号码</th>
							<th>积分</th>
                            <th>收藏</th>
							<th>头像地址</th>
							<th>操作</th>
						</tr>
						<!-- 遍历循环所有 -->
						<c:forEach items="${pb.beanList }" var="user">
							<tr>
								<td><input type="checkbox" name="IDCheck" value="14458579642011" class="acb" /></td>
                                <td>${user.uid }</td>
								<td>${user.username }</td>
								<td>${user.upassword}</td>
								<td>${user.uwechat}</td>
								<td>${user.utelephone }</td>
								<td>${user.uscore }</td>
								<td>${user.ustar }</td>
								<td>${user.uimage }</td>
							
								<td>
									<a href="javascript:to_editUI(${user.uid });" class="edit">编辑</a> 
									<a href="javascript:del(${user.uid });">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- 分页 -->
				<div class="ui_tb_h30">
					<c:choose>
						<c:when test="${empty pb.beanList }">
							<h1>暂时还没有记录</h1>
						</c:when>
						<c:otherwise>
							<%@ include file="/fenye/page.jsp" %>				
						</c:otherwise>
					</c:choose>	
				</div>
			</div>
		</div>
	</form>
</body>
</html>
