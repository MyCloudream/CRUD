package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qanda", catalog = "uoumomteaching")
public class Qanda {
    private Integer id;

    private String qanda;

    private Integer chid;

    private Integer seid;

    public Qanda(){}
    
    public Qanda(Integer id){
    	this.id = id;
    }
    
    public Qanda(Integer id, String qanda, Integer chid, Integer seid) {
		super();
		this.id = id;
		this.qanda = qanda;
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

    @Column(name = "qanda")
    public String getQanda() {
        return qanda;
    }

    public void setQanda(String qanda) {
        this.qanda = qanda == null ? null : qanda.trim();
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