<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<!-- 日期插件，使用jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.4.2.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/jquery/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick-zh-CN.js"></script>

<script type="text/javascript">
	$(function(){
		//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
		$("#timeId").datepick({dateFormat: 'yy-mm-dd'}); 
	});
	
</script>

</head>
<body>
<form id=form1 name=form1 action="${pageContext.request.contextPath }/house_update.action" method="post" enctype="multipart/form-data">		
	<input type="hidden" name="hid" value="${model.hid }"/>
	<input type="hidden" name="himage" value="${model.himage }" />
	<div id="container">
		<div id="nav_links">
			当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">修改房源</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">地区</td>
					<td class="ui_text_lt">
						<select name="haddress" id="fyXq" class="ui_select01">
                            <option value="">--请选择区--</option>
                            <option value="香洲区" <c:if test="${model.haddress eq '香洲区'}">selected="selected"</c:if> >香洲区</option>
                            <option value="金湾区" <c:if test="${model.haddress eq '金湾区'}">selected="selected"</c:if>>金湾区</option>
                            <option value="斗门区" <c:if test="${model.haddress eq '斗门区'}">selected="selected"</c:if>>斗门区</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">房子面积</td>
					<td class="ui_text_lt">
						<select name="harea" id="fyDh" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="60" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>60</option>
                            <option value="70" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>70</option>
                            <option value="80" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>80</option>
                            <option value="90" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>90</option>
                            <option value="100" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>100</option>
                            <option value="110" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>110</option>
                            <option value="120" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>120</option>
                            <option value="130" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>130</option>
                            <option value="140" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>140</option>
                            <option value="160" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>160</option>
                            <option value="220" <c:if test="${model.harea eq 60 }"> selected="selected"</c:if>>220</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">价格</td>
					<td class="ui_text_lt">
						<input type="text" class="ui_input_txt02" value="${model.hprice }" id="fyZongMj" name="hprice"/>元/㎡
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">可售时间:</td>
					<td>
						<INPUT id="timeId" value="${model.hsaletime }" name="hsaletime" readonly="readonly" class="ui_select01">
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">户型</td>
					<td class="ui_text_lt">
						<select name="" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="一室" <c:if test="${model.hshape eq '一室' }"> selected="selected"</c:if>>一室</option>
                            <option value="两室" <c:if test="${model.hshape eq '两室' }"> selected="selected"</c:if>>两室</option>
                            <option value="三室" <c:if test="${model.hshape eq '三室' }"> selected="selected"</c:if>>三室</option>
                            <option value="四室" <c:if test="${model.hshape eq '四室' }"> selected="selected"</c:if>>四室</option>
                             <option value="五室" <c:if test="${model.hshape eq '五室' }"> selected="selected"</c:if>>五室</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">性质</td>
					<td class="ui_text_lt">
						<select name="htype" id="submitForm_fangyuanEntity_fyJianzhuJiegou" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="0" <c:if test="${model.htype eq '0' }">selected="selected"</c:if> >可卖</option>
                            <option value="1" <c:if test="${model.htype eq '1' }">selected="selected"</c:if> >可租</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">名称</td>
					<td class="ui_text_lt">
						<input type="text" value="${model.hname }" class="ui_input_txt02" id="fyZongMj" name="hname"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">特点一</td>
					<td class="ui_text_lt">
						<input type="text" value="${model.subt1 }" class="ui_input_txt02" id="fyZongMj" name="subt1"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">特点二</td>
					<td class="ui_text_lt">
						<input type="text" ${model.subt2 } class="ui_input_txt02" id="fyZongMj" name="subt2"/>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">简介</td>
					<td class="ui_text_lt">
						<textarea rows="5" cols="25" name="hintroduction" >${model.hintroduction }</textarea>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">经纪人：</td>
					<td class="ui_text_lt">
						<select name="agent" id="agentID">
							<option>${model.agent.aname }</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">图片</td>
					<td class="ui_text_lt">
						<input type="file" name="upload" value="${pageContext.request.contextPath }/${model.himage }" />
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