package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "section", catalog = "uoumomteaching")
public class Section {
    private Integer id;
    private String name;
    private String type;
    private Integer serno;
    private Integer chid;

    public Section() {
    }
    public Section(Integer id) {
    	this.id = id;
    }

    public Section(Integer id, String name, String type, Integer serno, Integer chid) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.serno = serno;
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

    @Column(name = "name", length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "type", length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "serno")
    public Integer getSerno() {
        return serno;
    }

    public void setSerno(Integer serno) {
        this.serno = serno;
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
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", serno=" + serno +
                ", chid=" + chid +
                '}';
    }
}
