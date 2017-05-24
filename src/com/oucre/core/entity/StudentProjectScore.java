package com.oucre.core.entity;

import java.util.Date;

public class StudentProjectScore {
	private Integer id;
	private String name;
	private String mobile;
	private String content;
	private Integer score;
	private String url;
	private Date stime;

	public StudentProjectScore() {
		super();
	}

	public StudentProjectScore(Integer id,String name, String mobile, String content, Integer score, String url, Date stime) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.content = content;
		this.score = score;
		this.url = url;
		this.stime = stime;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	@Override
	public String toString() {
		return "StudentProjectScore [id=" + id + ", name=" + name + ", mobile=" + mobile + ", content=" + content
				+ ", score=" + score + ", url=" + url + ", stime=" + stime + "]";
	}

}
