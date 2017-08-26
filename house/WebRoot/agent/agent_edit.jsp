<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="${pageContext.request.contextPath }/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/artDialog/artDialog.js?skin=default"></script>
</head>
<body>
<form id="submitForm" name="submitForm" action="${pageContext.request.contextPath }/agent_update.action" enctype="multipart/form-data"  method="post">
	<!-- 隐藏域id -->
	<input type="hidden" name="aid" value="${model.aid }"/>
	<!-- 隐藏域图片位置 -->
	<input type="hidden" name="aimage" value="${model.aimage }"/>
	
	<div id="container">
		<div id="nav_links">
			当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">修改经纪人</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
					<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt"  width="80">姓名</td>
					<td class="ui_text_lt">
						<input type="text" value="${model.aname }" id="name" name="aname" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">性别</td>
					<td class="ui_text_lt">
						<select name="asex" id="sex" class="ui_select01">
                            <option value="男" <c:if test="${model.asex eq '男' }">selected="selected"</c:if>>男</option>
                            <option value="女" <c:if test="${model.asex eq '女' }">selected="selected"</c:if>>女</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">公司</td>
					<td class="ui_text_lt">
						<input type="text" id="company" name="acompany" value="${model.acompany }" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">手机号码</td>
					<td class="ui_text_lt">
						<input type="text" id="telephone" name="atelephone" value="${model.atelephone }" class="ui_input_txt02"/></td>
				</tr>
				<tr>
					<td class="ui_text_rt">微信号码</td>
					<td class="ui_text_lt">
						<input type="text" id="WeChat" name="awechat"  value="${model.awechat }" class="ui_input_txt02"/></td>
				</tr>
				<tr>
					<td class="ui_text_rt">服务年限</td>
					<td class="ui_text_lt">
						<input type="text" id="fyJizuMj" name="aservice_time"  value="${model.aservice_time }" class="ui_input_txt01"/>
						年</td>
				</tr>
				<tr>
					<td class="ui_text_rt">服务人数</td>
					<td class="ui_text_lt">
						<input type="text" id="fyJizuMj" name="aservice_number" value="${model.aservice_number }" class="ui_input_txt01"/>
						人</td>
				</tr>
				<tr>
					<td class="ui_text_rt">服务地区</td>
					<td>
						<select name="aservice_address" id="fyXq" class="ui_select01">
                              <option value="金湾区" <c:if test="${model.aservice_address eq '金湾区' }"> selected="selected"</c:if>>金湾区</option>
                              <option value="香洲区" <c:if test="${model.aservice_address eq '香洲区' }"> selected="selected"</c:if>>香洲区</option>
                              <option value="斗门区" <c:if test="${model.aservice_address eq '斗门区' }"> selected="selected"</c:if>>斗门区</option>
                          </select>
                    </td>
				</tr>
				<tr>
					<td class="ui_text_rt">头像</td>
					<td class="ui_text_lt">
						<input type="file" name="upload"/>
					</td>
				</tr>
				<br/>
				<br/>
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