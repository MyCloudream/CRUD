package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projecttraining", catalog = "uoumomteaching")
public class Projecttraining {
    private Integer id;
    private String content;
    private Integer chid;

    public Projecttraining() {
    }
    
    public Projecttraining(Integer id){
    	this.id = id;
    }

    public Projecttraining(Integer id, String content, Integer chid) {
        this.id = id;
        this.content = content;
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

    @Column(name="content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Projecttraining{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", chid=" + chid +
                '}';
    }
}
