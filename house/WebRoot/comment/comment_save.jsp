<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery/jquery-1.7.1.js"></script>
<link href="${pageContext.request.contextPath }/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="${pageContext.request.contextPath }/scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/artDialog/artDialog.js?skin=default"></script>
<!-- 日期插件，使用jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.4.2.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/jquery/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick-zh-CN.js"></script>

<script type="text/javascript">
	$(function(){
		//jquery时间插件处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
		$("#timeId").datepick({dateFormat: 'yy-mm-dd'}); 
		
	});
	
	
	
</script>

</head>
<body>
<form id=form1 name=form1 action="${pageContext.request.contextPath }/comment_save.action" method="post" enctype="multipart/form-data">		
	<input type="hidden" name="uid" value="${uid}" />
	<input type="hidden" name="hid" value="${hid }">
	<input type="hidden" name="nid" value="${nid }">
	<div id="container">
		<div id="nav_links">
			当前位置：评论管理&nbsp;>&nbsp;<span style="color: #1A5CC6;">添加评论</span>
			<div id="page_close">
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
			
				
				
				
				<tr>
					<td class="ui_text_rt">评论内容</td>
					<td class="ui_text_lt">
						<textarea  rows="5" cols="25" name="content" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">图片</td>
					<td class="ui_text_lt">
						<input type="file" name="upload" />
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="submit" value="提交" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</body>
</html>