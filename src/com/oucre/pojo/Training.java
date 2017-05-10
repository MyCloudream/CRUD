package com.oucre.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "training", catalog = "uoumomteaching")
public class Training {
    private Integer id;

    private String type;

    private String degree;

    private String question;

    private String optiona;

    private String optionb;

    private String optionc;

    private String optiond;

    private String answer;

    private String explains;

    private Integer chid;

    private Integer seid;
    
    public Training(){}
    
    public Training(Integer id){
    	this.id = id;
    }
    
    public Training(Integer id, String type, String degree, String question, String optiona, String optionb,
			String optionc, String optiond, String answer, String explains, Integer chid, Integer seid) {
		super();
		this.id = id;
		this.type = type;
		this.degree = degree;
		this.question = question;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.answer = answer;
		this.explains = explains;
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
    
    @Column(name = "type", length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Column(name = "degree", length = 1)
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    @Column(name = "question", length = 500)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    @Column(name = "optiona", length = 100)
    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona == null ? null : optiona.trim();
    }

    @Column(name = "optionb", length = 100)
    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb == null ? null : optionb.trim();
    }

    @Column(name = "optionc", length = 100)
    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc == null ? null : optionc.trim();
    }

    @Column(name = "optiond", length = 100)
    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond == null ? null : optiond.trim();
    }

    @Column(name = "answer", length = 10)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    @Column(name = "explains", length = 500)
    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains == null ? null : explains.trim();
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

	@Override
	public String toString() {
		return "Training [id=" + id + ", type=" + type + ", degree=" + degree + ", question=" + question + ", optiona="
				+ optiona + ", optionb=" + optionb + ", optionc=" + optionc + ", optiond=" + optiond + ", answer="
				+ answer + ", explains=" + explains + ", chid=" + chid + ", seid=" + seid + "]";
	}
}