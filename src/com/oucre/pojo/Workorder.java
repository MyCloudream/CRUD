package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workorder", catalog = "uoumomteaching")
public class Workorder {
    private Integer id;

    private String title;

    private String content;

    private String answer;

    private Date atime;

    private Date qtime;

    private Integer sid;

    private Integer eid;

    public Workorder(){}
    
    public Workorder(Integer id){
    	this.id = id;
    }
    
    public Workorder(Integer id, String title, String content, String answer, Date atime, Date qtime, Integer sid,
			Integer eid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.answer = answer;
		this.atime = atime;
		this.qtime = qtime;
		this.sid = sid;
		this.eid = eid;
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

    @Column(name = "title", length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    @Column(name = "atime")
    public Date getAtime() {
        return atime;
    }

    public void setAtime(Date atime) {
        this.atime = atime;
    }

    @Column(name = "qtime")
    public Date getQtime() {
        return qtime;
    }

    public void setQtime(Date qtime) {
        this.qtime = qtime;
    }

    @Column(name = "sid")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Column(name = "eid")
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}