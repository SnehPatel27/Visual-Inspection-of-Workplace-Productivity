package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Complaint")
public class ComplaintVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;

	@Column(name = "ComplainSubject")
	private String complainsubject;

	@Column(name = "ComplainDescription")
	private String complaindescription;

	@Column(name = "ComplainDate")
	private String complaindate;

	@Column(name = "ComplainReply")
	private String complainreply;

	@Column(name = "ComplainReplyDate")
	private String complainreplydate;

	private String fileName;
	private String filePath;

	@Column(name = "Status")
	private String status;
	
	@Column(name="ComplainStatus")
	private boolean complainstatus = true;

	@ManyToOne
	private LoginVO loginvo;

	public boolean isComplainstatus() {
		return complainstatus;
	}

	public void setComplainstatus(boolean complainstatus) {
		this.complainstatus = complainstatus;
	}

	public String getComplainreplydate() {
		return complainreplydate;
	}

	public void setComplainreplydate(String complainreplydate) {
		this.complainreplydate = complainreplydate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComplainsubject() {
		return complainsubject;
	}

	public void setComplainsubject(String complainsubject) {
		this.complainsubject = complainsubject;
	}

	public String getComplaindescription() {
		return complaindescription;
	}

	public void setComplaindescription(String complaindescription) {
		this.complaindescription = complaindescription;
	}

	public String getComplaindate() {
		return complaindate;
	}

	public void setComplaindate(String complaindate) {
		this.complaindate = complaindate;
	}

	public String getComplainreply() {
		return complainreply;
	}

	public void setComplainreply(String complainreply) {
		this.complainreply = complainreply;
	}

	public LoginVO getLoginvo() {
		return loginvo;
	}

	public void setLoginvo(LoginVO loginvo) {
		this.loginvo = loginvo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
