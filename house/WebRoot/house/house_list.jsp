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
	// 删除
	function del(hid){
		// 非空判断
		if(hid == '') return;
		if(confirm("您确定要删除吗？")){
			$("#submitForm").attr("action", "${pageContext.request.contextPath}/house_delete.action?hid=" + hid).submit();			
		}
	}
	// 有条件搜索
	function search(){
		$("#submitForm").attr("action","${pageContext.request.contextPath}/house_findByPage.action").submit();
	}
	
	// 到达编辑页面
	function to_updatePage(hid){
		if(hid == '') return;
		$("#submitForm").attr("action","${pageContext.request.contextPath}/house_editUI.action?hid=" + hid).submit();
	}
	
	// 查看每个房源下面的评论
	function getComments(hid){
		if(hid == '') return ;
		// 该如何传递房子的id
		$("#submitForm").attr("action","${pageContext.request.contextPath}/comment_findByPage?hid=" + hid).submit();
	}
	// 添加房源下的新闻
	function addNews(hid){
		if(hid == '') return ;
		// 该如何传递房子的id
		$("#submitForm").attr("action","${pageContext.request.contextPath}/news_addUI.action?hid=" + hid).submit();
	}
	// 管理房源下的新闻
	function findNews(hid){
		if(hid == '') return ;
		// 该如何传递房子的id
		$("#submitForm").attr("action","${pageContext.request.contextPath}/news_findByPage.action?hid=" + hid).submit();
	}
	
	function findNewsByUser(hid,uid){
		if(hid == '') return ;
		// 该如何传递房子的id
		$("#submitForm").attr("action","${pageContext.request.contextPath}/news_findByPage.action?hid=" + hid+"&&uid="+uid).submit();
	}
	
	function jumpInputPage(pageCode){
		$("#submitForm").attr("action","${pageContext.request.contextPath}/house_findByPage?pageCode=" + pageCode).submit();
	}
	
</script>

<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							地区
							<select name="haddress" id="fyXq" class="ui_select01">
                                <option value="">--请选择--</option>
                                <option value="金湾区">金湾区</option>
                                <option value="香洲区">香洲区</option>
                                <option value="斗门区">斗门区</option>
                            </select>

							面积
							<select name="area" id="fyDh" class="ui_select01">
                                <option value="">--请选择--</option>
                                <option value="0-60">&lt60</option>
                                <option value="60-80">60-80</option>
                                <option value="80-100">80-100</option>
                                <option value="100-120">100-120</option>
                                <option value="120-150">120-150</option>
                                <option value="150-200">150-200</option>
                                <option value="200-300">&gt200</option>
                            </select>
                            
                                                                          价格
							<select name="price" id="fyDh" class="ui_select01">
                                <option value="">--请选择--</option>
                                <option value="0.0-10000.0">&lt10000</option>
                                <option value="10000.0-15000.0">10000-15000</option>
                                <option value="15000.0-20000.0">15000-20000</option>
                                <option value="20000.0-30000.0">20000-30000</option>
                                <option value="30000.0-40000.0">30000-40000</option>
                                <option value="40000.0-50000.0">&gt40000</option>
                               
                            </select>
						&nbsp&nbsp		户型
							<select name="hshape" id="fyHx" class="ui_select01">
                                <option value="">--请选择--</option>
                                <option value="一室">一室</option>
                                <option value="两室">两室</option>
                                <option value="三室">三室</option>
                                <option value="四室">四室</option>
                                    <option value="五室">五室</option>
                            </select>
					&nbsp&nbsp	特色
						<select name="subt1" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="微聊" >微聊</option>
                            <option value="沙盘楼">沙盘楼</option>
                            <option value="视频看房">三室</option>
                        </select>
				
				
		   		&nbsp&nbsp	物业
					
						<select name="subt2" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="住宅" >住宅</option>
                            <option value="别墅">别墅</option>
                            <option value="商住">商住</option>
                            <option value="商铺">商铺</option>
                              <option value="写字楼">写字楼</option>
                        </select>
				&nbsp&nbsp热门标签
						<select name="hintroduction" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="刚需房">刚需房</option>
                            <option value="优惠打折">优惠打折</option>
                            <option value="不限购">不限购</option>
                            <option value="即将开盘">即将开盘</option>
            				<option value="非毛坯">非毛坯</option>
            				  <option value="改善房">改善房</option>
                        </select>
						</div>
						<div id="box_bottom">
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
							<th>位置</th>
							<th>面积</th>
							<th>价格</th>
							<th>户型</th>
							<th>名称</th>
							<th>经纪人</th>
                            <th>特点</th>
							<th>操作</th>
						</tr>
				<c:forEach items="${pb.beanList }" var="house" >		
						<tr>
							<td><input type="checkbox" name="IDCheck" value="14458579642011" class="acb" /></td>
                            <td>${house.hid }</td>
							<td>${house.haddress }</td>
							<td>${house.harea }</td>
							<td>${house.hprice }元/㎡</td>
							<td>${house.hshape }</td>
							<td>${house.hname }</td>
							<td>${house.agent.aname }</td>
							<td>${house.subt1 }　${house.subt2 }</td>
							<td>
								<c:choose>
						<c:when test="${empty uid }">
							<a href="javascript:to_updatePage(${house.hid});" class="edit">编辑</a> 
								<a href="javascript:del(${house.hid });">删除</a>
								<a href="javascript:getComments(${house.hid });">查看评论</a>
								<a href="javascript:addNews(${house.hid });">添加新闻</a>
								<a href="javascript:findNews(${house.hid });">管理新闻</a>
						</c:when>
						<c:otherwise>
									<a href="javascript:findNewsByUser(${house.hid },${uid});">查看新闻</a>		
						</c:otherwise>
					</c:choose>		
								
							</td>
						</tr>
					</c:forEach>	
					</table>
				</div>
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
