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
@Table(name = "material", catalog = "uoumomteaching")
public class Material implements Serializable{
	private Integer id;
	private String name;
//	private String no;
	private Double size;
	private Integer type;
	private Integer suffix;
	private String animation;
	private Double price;
	private Integer bean;
	private String url;
	private String passwd;
	private String mdesc;
	private String content;
	private String img;
	private Date mtime;

	public Material() {
	}
	
	public Material(Integer id){
		this.id = id;
	}

	public Material(Integer id, String name, Double size, Integer type, Integer suffix, String animation, Double price,
			Integer bean, String url, String passwd, String mdesc, String content, String img,Date mtime) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.type = type;
		this.suffix = suffix;
		this.animation = animation;
		this.price = price;
		this.bean = bean;
		this.url = url;
		this.passwd = passwd;
		this.mdesc = mdesc;
		this.content = content;
		this.img = img;
		this.mtime = mtime;
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

	@Column(name = "name", length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	@Column(name = "no", length = 15)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}*/

	@Column(name = "size")
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column(name = "suffix")
	public Integer getSuffix() {
		return suffix;
	}

	public void setSuffix(Integer suffix) {
		this.suffix = suffix;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
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
	
	@Column(name="img",length=100)
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "mtime")
	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", size=" + size + ", type=" + type + ", suffix=" + suffix
				+ ", animation=" + animation + ", price=" + price + ", bean=" + bean + ", url=" + url + ", passwd="
				+ passwd + ", mdesc=" + mdesc + ", content=" + content + ", mtime=" + mtime + "]";
	}

}
