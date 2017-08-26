package com.house.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 新闻实体类
 * @author ming
 *
 */
public class News {
	/**
	nid : 新闻id
	ntitle：新闻标题
	ntime: 动态更新时间
	ncontent: 评论内容
	comment: 动态下的评论
	house :新闻对应的房子
	 */
	private Long nid;
	private String ntitle;
	private Date ntime;
	private String ncontent;
	private House house;
	
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@JSONField(serialize=false)
	private Set<Comment> comments = new HashSet<Comment>();
	
	public Long getNid() {
		return nid;
	}
	public void setNid(Long nid) {
		this.nid = nid;
	}
	public Date getNtime() {
		return ntime;
	}
	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
}
