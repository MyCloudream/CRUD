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
	private String username;
	private String password;
	private String tel;
	private String qq;
	private String status;

	// Constructors

	/** default constructor */
	public User() {
	}

	public User(Integer id, Integer roleid, String username, String password,
			String tel, String qq, String status) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.username = username;
		this.password = password;
		this.tel = tel;
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

	@Column(name = "username", length = 10)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 22)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
		return "User [id=" + id + ", roleid=" + roleid + ", username=" + username + ", password=" + password + ", tel="
				+ tel + ", qq=" + qq + ", status=" + status + "]";
	}

}