package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CompanyDetailsVO")
public class CompanyDetailsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;

	@Column(name = "CEOName")
	private String ceoname;

	@Column(name = "CEOEmail")
	private String ceoemailid;

	@Column(name = "CEOContact")
	private String ceocontact;

	@Column(name = "HRName")
	private String hrname;

	@Column(name = "HREmail")
	private String hremailid;

	@Column(name = "HRContact")
	private String hrcontact;

	@Column(name = "Status")
	private boolean status = true;

	@ManyToOne
	private LoginVO loginVO;


	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCeoname() {
		return ceoname;
	}

	public void setCeoname(String ceoname) {
		this.ceoname = ceoname;
	}

	public String getCeoemailid() {
		return ceoemailid;
	}

	public void setCeoemailid(String ceoemailid) {
		this.ceoemailid = ceoemailid;
	}

	public String getCeocontact() {
		return ceocontact;
	}

	public void setCeocontact(String ceocontact) {
		this.ceocontact = ceocontact;
	}

	public String getHrname() {
		return hrname;
	}

	public void setHrname(String hrname) {
		this.hrname = hrname;
	}

	public String getHremailid() {
		return hremailid;
	}

	public void setHremailid(String hremailid) {
		this.hremailid = hremailid;
	}

	public String getHrcontact() {
		return hrcontact;
	}

	public void setHrcontact(String hrcontact) {
		this.hrcontact = hrcontact;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
