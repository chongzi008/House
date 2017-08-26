package com.house.domain;

import java.util.Date;

/**
 * 评论实体类
 * @author ming
 *
 */
public class Comment {

	/**
	 * 	cid : 评论id
	ctime : 评论时间
	ccontent: 评论内容
	cimage ： 评论图片
	uid : 用户id(那个用户评论)
	hid ：房屋id（在哪栋房子下面评论）
	 */
	private Long cid;
	private Date ctime;
	private String content;
	private String cimage;
	private User user;
	private House house;
	private News news;
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCimage() {
		return cimage;
	}
	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
}
