package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material_suffix", catalog = "uoumomteaching")
public class MaterialSuffix implements Serializable{
	private Integer id;
	private String name;
	private String no;
	private Integer tid;
	public MaterialSuffix() {
		super();
	}

	public MaterialSuffix(Integer id) {
		this.id = id;
	}

	public MaterialSuffix(Integer id, String name, String no,Integer tid) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.tid = tid;
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

	@Column(name="tid")
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

}
