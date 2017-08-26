package com.house.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 房屋实体
 * @author ming
 *
 */
public class House {
	/**
	hid: 房屋id
	hname: 房子名称
	hmoney:房屋价格
	himage:房屋图片
	hsaletime: 开盘时间
	haddress:地址
	htype：房屋类型（0：卖房 1：租房 ）
	harea:面积
	hintroduction: 房屋简介
	his_new: 是否新房(1:新房  0：旧房)
	aid:房屋经纪人id	(从属于那个经纪人)
	*
	*/
	private Long hid;
	private String hname;
	private Double hprice;
	private String himage;
	private Date hsaletime;
	private String haddress;
	private String hshape;
	private String subt1;	// 保存两个小标题
	private String subt2;	
	private Integer htype = 1;	// 房屋类型（0：卖房 1：租房） 
	private String hintroduction;
	private Integer harea;
	private Agent agent;		// 房屋经纪人
	
	// 每个房子下面对应的评论
	@JSONField(serialize=false)
	private Set<Comment> comments = new HashSet<Comment>();
	
	//每个房子下面对应的新闻
	private Set<News> news=new HashSet<News>();

	
	public Set<News> getNews() {
		return news;
	}

	public void setNews(Set<News> news) {
		this.news = news;
	}

	public Integer getHarea() {
		return harea;
	}

	public void setHarea(Integer harea) {
		this.harea = harea;
	}
	
	public String getHshape() {
		return hshape;
	}

	public void setHshape(String hshape) {
		this.hshape = hshape;
	}

	public String getSubt1() {
		return subt1;
	}

	public void setSubt1(String subt1) {
		this.subt1 = subt1;
	}

	public String getSubt2() {
		return subt2;
	}

	public void setSubt2(String subt2) {
		this.subt2 = subt2;
	}
	
	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public Double getHprice() {
		return hprice;
	}

	public void setHprice(Double hprice) {
		this.hprice = hprice;
	}
	
	public String getHimage() {
		return himage;
	}

	public void setHimage(String himage) {
		this.himage = himage;
	}

	public Date getHsaletime() {
		return hsaletime;
	}

	public void setHsaletime(Date hsaletime) {
		this.hsaletime = hsaletime;
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public Integer getHtype() {
		return htype;
	}

	public void setHtype(Integer htype) {
		this.htype = htype;
	}

	public String getHintroduction() {
		return hintroduction;
	}

	public void setHintroduction(String hintroduction) {
		this.hintroduction = hintroduction;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}	
