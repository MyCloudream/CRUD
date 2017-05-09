package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chapter", catalog = "uoumomteaching")
public class Chapter {
	private Integer id;

	private String name;

	private String cdesc;

	
	
	public Chapter() {
		super();
	}
	public Chapter(Integer id) {
		super();
		this.id = id;
	}

	public Chapter(Integer id, String name, String cdesc) {
		super();
		this.id = id;
		this.name = name;
		this.cdesc = cdesc;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	@Column(name = "cdesc", length = 500)
	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc == null ? null : cdesc.trim();
	}
}