<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="../style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="../style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="../scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer></script>
<script type="text/javascript" src="../scripts/artDialog/artDialog.js?skin=default"></script>
</head>
<body>
<form id="submitForm" name="submitForm" action="${pageContext.request.contextPath }/user_save.action" enctype="multipart/form-data"  method="post">
	<input type="hidden" name="fyID" value="14458625716623" id="fyID"/>
	<div id="container">
		<div id="nav_links">
		当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">添加用户</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
					<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">用户名</td>
					<td class="ui_text_lt">
						<input type="text" id="username" name="username" class="ui_input_txt02"/>
					</td>
				</tr>
			<tr>
					<td class="ui_text_rt" width="80">密码</td>
					<td class="ui_text_lt">
						<input type="text" id="upassword" name="upassword" class="ui_input_txt02"/>
					</td>
				</tr>
			
				<tr>
					<td class="ui_text_rt">手机号码</td>
					<td class="ui_text_lt">
						<input type="text" id="utelephone" name="utelephone" class="ui_input_txt02"/></td>
				</tr>
				<tr>
					<td class="ui_text_rt">微信号码</td>
					<td class="ui_text_lt">
						<input type="text" id="uwechat" name="uwechat"  class="ui_input_txt02"/></td>
				</tr>		
					<tr>
					<td class="ui_text_rt">积分</td>
					<td class="ui_text_lt">
						<input type="text" id="uscore" name="uscore" class="ui_input_txt02"/></td>
				</tr>
					<tr>
					<td class="ui_text_rt">收藏</td>
					<td class="ui_text_lt">
						<input type="text" id="ustar" name="ustar" class="ui_input_txt02"/></td>
				</tr>
				<tr>
					<td class="ui_text_rt">头像</td>
					<td class="ui_text_lt">
						<input type="file" name="upload"/>
					</td>
				</tr>
				
				
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input  type="submit" value="提交" class="ui_input_btn01"/>
						&nbsp;<input  type="submit" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</body>
</html>