package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score", catalog = "uoumomteaching")
public class Score implements Serializable{
	private Integer id;
	private String type;
	private Integer score;
	private Date stime;
	private String url;
	private Integer sid;
	private Integer chid;
	private Integer emid;
	private Integer pid;

	public Score() {
		super();
	}

	public Score(Integer id, String type, Integer score, Date stime, String url, Integer sid, Integer chid,
			Integer emid, Integer pid) {
		super();
		this.id = id;
		this.type = type;
		this.score = score;
		this.stime = stime;
		this.url = url;
		this.sid = sid;
		this.chid = chid;
		this.emid = emid;
		this.pid = pid;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "type", length = 1)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "stime")
	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	@Column(name = "url", length = 50)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "sid")
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "chid")
	public Integer getChid() {
		return chid;
	}

	public void setChid(Integer chid) {
		this.chid = chid;
	}

	@Column(name = "emid")
	public Integer getEmid() {
		return emid;
	}

	public void setEmid(Integer emid) {
		this.emid = emid;
	}

	
	@Column(name = "pid")
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

}
