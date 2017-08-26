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
	
	// 当选中区域时，获取该区域的所有经纪人
	function getAgent(){
		var data = $("#area").val();
		var url = "${pageContext.request.contextPath}/agent_findByArea.action";
		$.post(url,{ area: data },function(data){
			$(data).each(function(i,n){
				$("#agentID").append("<option value='"+n.aid+"'>"+n.aname+"</option>");
			});
		},"json");
	}
	
</script>

</head>
<body>
<form id=form1 name=form1 action="${pageContext.request.contextPath }/house_findByPage.action" method="post" enctype="multipart/form-data">		
	<input type="hidden" name="fyID" value="14458625716623" id="fyID"/>
	<div id="container">
		<div id="nav_links">
			当前位置：房源管理&nbsp;>&nbsp;<span style="color: #1A5CC6;">添加房源</span>
			<div id="page_close">
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">地区</td>
					<td class="ui_text_lt">
						<select name="haddress"  onchange="getAgent();" id="area" class="ui_select01">
                            <option value="" selected="selected" >--请选择区--</option>
                            <option value="香洲区">香洲区</option>
                            <option value="金湾区">金湾区</option>
                            <option value="斗门区">斗门区</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">房子面积</td>
					<td class="ui_text_lt">
						<select name="harea" id="fyDh" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="60" selected="selected">60</option>
                            <option value="70">70</option>
                            <option value="80">80</option>
                            <option value="90">90</option>
                            <option value="100">100</option>
                            <option value="110">110</option>
                            <option value="120">120</option>
                             <option value="130">130</option>
                            <option value="140">140</option>
                            <option value="160">160</option>
                            <option value="220">220</option>
                        </select>
					</td>
				</tr>
			
				
				<tr>
					<td class="ui_text_rt">户型</td>
					<td class="ui_text_lt">
						<select name="hshape" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="一室" selected="selected">一室</option>
                            <option value="两室">两室</option>
                            <option value="三室">三室</option>
                            <option value="四室">四室</option>
                              <option value="五室">五室</option>
                        </select>
					</td>
				</tr>
					<tr>
					<td class="ui_text_rt">特色</td>
					<td class="ui_text_lt">
						<select name="subt1" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="微聊" selected="selected">微聊</option>
                            <option value="沙盘楼">沙盘楼</option>
                            <option value="视频看房">三室</option>
                         
                         
                        </select>
					</td>
				</tr>
		
		   			<tr>
					<td class="ui_text_rt">物业</td>
					<td class="ui_text_lt">
						<select name="subt2" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="住宅" selected="selected">住宅</option>
                            <option value="别墅">别墅</option>
                            <option value="商住">商住</option>
                            <option value="商铺">商铺</option>
                              <option value="写字楼">写字楼</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">热门标签</td>
					<td class="ui_text_lt">
						<select name="hintroduction" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="刚需房" selected="selected">刚需房</option>
                            <option value="优惠打折">优惠打折</option>
                            <option value="不限购">不限购</option>
                            <option value="即将开盘">即将开盘</option>
            				<option value="非毛坯">非毛坯</option>
            				  <option value="改善房">改善房</option>
                        </select>
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