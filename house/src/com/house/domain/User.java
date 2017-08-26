package com.house.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户实体类
 * @author ming
 *
 */
public class User {
/**
 * 
	uid:用户id
	uimage: 用户头像
	username:用户名
	upassword：密码
	utelephone: 手机号码
	uwechat： 微信号码
	ustar : 收藏
	uscore: 积分
 */
	private Long uid;
	private String uimage;
	private String username;
	private String upassword;
	private String utelephone; 
	private String uwechat;
	private String ustar;
	private Integer uscore=0;
	
	// 用户所有的评论
	@JSONField(serialize=false)
	private Set<Comment> comments = new HashSet<Comment>();
	
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUimage() {
		return uimage;
	}
	public void setUimage(String uimage) {
		this.uimage = uimage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
	public String getUwechat() {
		return uwechat;
	}
	public void setUwechat(String uwechat) {
		this.uwechat = uwechat;
	}
	public String getUstar() {
		return ustar;
	}
	public void setUstar(String ustar) {
		this.ustar = ustar;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Integer getUscore() {
		return uscore;
	}
	public void setUscore(Integer uscore) {
		this.uscore = uscore;
	}
}
