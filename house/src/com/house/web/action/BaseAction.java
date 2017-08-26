package com.house.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 *  Action基类
 * @author ming
 */
@SuppressWarnings("all")
public class BaseAction extends ActionSupport {
	// 定义一些结果集常量
	protected static final String SAVE = "save";
	protected static final String UPDATE = "update";
	protected static final String DELETE = "delete";
	protected static final String PAGE = "page";
	
	// 属性驱动的方式
	// 当前页，默认值就是1
	private Integer pageCode = 1;
	public void setPageCode(Integer pageCode) {
		if(pageCode == null){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}
	public Integer getPageCode() {
		return pageCode;
	}
	
	// 每页显示的数据的条数
	private Integer pageSize = 8;
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置值栈对象
	 * @param key
	 * @param obj
	 */
	public void setVs(String key, Object obj){
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set(key, obj);
	}
	
	/**
	 * 返回reques请求域
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	/**
	 * 根据文件路径，返回文件的真实路径
	 * @param filePath
	 * @return
	 */
	public String getRealPath(String filePath){
		return getRequest().getSession().getServletContext().getRealPath(filePath);
	}
	
}
