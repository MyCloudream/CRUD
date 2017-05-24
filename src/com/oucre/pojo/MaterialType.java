package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material_type", catalog = "uoumomteaching")
public class MaterialType implements Serializable{
	private Integer id;
	private String name;
	private String no;

	public MaterialType() {
		super();
	}

	public MaterialType(Integer id) {
		this.id = id;
	}

	public MaterialType(Integer id, String name, String no) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
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

	@Column(name = "name", length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "no", length = 1)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

}
