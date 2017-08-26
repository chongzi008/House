package com.house.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 经纪人实体类
 * @author ming
 *
 */
public class Agent {
	/**
	aid:经纪人id
	aimage: 经纪人照片
	aname：姓名
	acompany:经纪人从事公司
	atelephone:手机号码
	awechat:微信号码
	aservice_time: 服务年限	
	aservice_number:服务人数
	aservice_address:服务地区（主营范围）
	 */
	private Long aid;
	private String aimage;
	private String aname;
	private String acompany;
	private String atelephone;
	private String awechat;
	private Integer aservice_time;
	private Integer aservice_number;
	private String aservice_address;
	private String asex;
	
	// 自己所管辖的房子
	@JSONField(serialize=false)
	private Set<House> house = new HashSet<House>();
	
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getAimage() {
		return aimage;
	}
	public void setAimage(String aimage) {
		this.aimage = aimage;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAcompany() {
		return acompany;
	}
	public void setAcompany(String acompany) {
		this.acompany = acompany;
	}
	public String getAtelephone() {
		return atelephone;
	}
	public void setAtelephone(String atelephone) {
		this.atelephone = atelephone;
	}
	public String getAwechat() {
		return awechat;
	}
	public void setAwechat(String awechat) {
		this.awechat = awechat;
	}
	public Integer getAservice_time() {
		return aservice_time;
	}
	public void setAservice_time(Integer aservice_time) {
		this.aservice_time = aservice_time;
	}
	public Integer getAservice_number() {
		return aservice_number;
	}
	public void setAservice_number(Integer aservice_number) {
		this.aservice_number = aservice_number;
	}
	public String getAservice_address() {
		return aservice_address;
	}
	public void setAservice_address(String aservice_address) {
		this.aservice_address = aservice_address;
	}
	public Set<House> getHouse() {
		return house;
	}
	public void setHouse(Set<House> house) {
		this.house = house;
	}
}
