package com.oucre.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "uoumomteaching")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleid;
	private String nick;
	private String passwd;
	private String mobile;
	private String qq;
	private String status;

	// Constructors

	/** default constructor */
	public User() {
	}

	public User(Integer id, Integer roleid, String nick, String passwd,
			String mobile, String qq, String status) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.nick = nick;
		this.passwd = passwd;
		this.mobile = mobile;
		this.qq = qq;
		this.status = status;
	}

	public User(Integer id) {
		this.id = id;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "roleid")
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "nick", length = 10)
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "passwd", length = 32)
	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(name = "status", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Column(name = "qq", length = 20)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", roleid=" + roleid + ", nick=" + nick + ", passwd=" + passwd + ", mobile=" + mobile
				+ ", qq=" + qq + ", status=" + status + "]";
	}

}