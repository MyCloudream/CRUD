package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video", catalog = "uoumomteaching")
public class Video {
    private Integer id;
    private String url;
    private Integer seid;
    private Integer chid;

    public Video() {
    }
    public Video(Integer id) {
    	this.id = id;
    }

    public Video(Integer id, String url, Integer seid,Integer chid) {
        this.id = id;
        this.url = url;
        this.seid = seid;
        this.chid = chid;
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

    @Column(name = "url", length = 200)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "seid")
    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    @Column(name = "chid")
    public Integer getChid() {
		return chid;
	}
    
	public void setChid(Integer chid) {
		this.chid = chid;
	}
	
	@Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", seid=" + seid +
                '}';
    }
}
