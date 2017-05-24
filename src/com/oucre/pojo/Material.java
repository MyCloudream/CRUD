package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material", catalog = "uoumomteaching")
public class Material {
	private Integer id;
	private String name;
	private String no;
	private Double size;
	private String suffix;
	private String type;
	private String animation;
	private Double price;
	private Integer bean;
	private String url;
	private String passwd;
	private String mdesc;
	private String content;

	public Material() {
	}
	
	public Material(Integer id){
		this.id = id;
	}

	public Material(Integer id, String name, String no, Double size, String suffix, String type,
			String animation, Double price, Integer bean, String url, String passwd, String mdesc,String content) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.size = size;
		this.suffix = suffix;
		this.type = type;
		this.animation = animation;
		this.price = price;
		this.bean = bean;
		this.url = url;
		this.passwd = passwd;
		this.mdesc = mdesc;
		this.content = content;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "no", length = 15)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Column(name = "size")
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column(name = "suffix", length = 15)
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name = "type", length = 10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "animation", length = 1)
	public String getAnimation() {
		return animation;
	}

	public void setAnimation(String animation) {
		this.animation = animation;
	}

	@Column(name = "price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "bean")
	public Integer getBean() {
		return bean;
	}

	public void setBean(Integer bean) {
		this.bean = bean;
	}

	@Column(name = "url", length = 100)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "passwd", length = 6)
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Column(name="mdesc")
	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", no=" + no + ", size=" + size + ", suffix=" + suffix
				+ ", type=" + type + ", animation=" + animation + ", price=" + price + ", bean=" + bean + ", url=" + url
				+ ", passwd=" + passwd + ", content=" + content + "]";
	}

}
