<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
 <!-- 分页 -->
<div class="ui_flt" style="height: 30px; line-height: 30px;">
	共有<span class="ui_txt_bold04">${pb.totalCount }</span>条记录，
	当前第<span class="ui_txt_bold04">${pb.pageCode }/${pb.totalPage }</span>页
</div>
<div class="ui_frt">
	<c:if test="${pb.pageCode > 1}">
	[<A href="javascript:jumpInputPage(${pb.pageCode-1})">上一页</A>]
	</c:if>
	<c:if test="${pb.pageCode < pb.totalPage}">
	[<A href="javascript:jumpInputPage(${pb.pageCode+1})">下一页</A>]
	</c:if>
</div>