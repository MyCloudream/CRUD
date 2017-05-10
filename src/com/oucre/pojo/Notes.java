package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes", catalog = "uoumomteaching")
public class Notes {
    private Integer id;

    private String notes;

    private Integer chid;

    private Integer seid;

    public Notes(){}
    
    public Notes(Integer id){
    	this.id = id;
    }
    
    public Notes(Integer id, String notes, Integer chid, Integer seid) {
		super();
		this.id = id;
		this.notes = notes;
		this.chid = chid;
		this.seid = seid;
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

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }
    
    @Column(name = "chid")
    public Integer getChid() {
		return chid;
	}

	public void setChid(Integer chid) {
		this.chid = chid;
	}

	@Column(name = "seid")
	public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }
}