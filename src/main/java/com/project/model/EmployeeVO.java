package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeVO")
public class EmployeeVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;

	@Column(name = "EmployeeName")
	private String employeename;

	@Column(name = "EmployeeId")
	private String employeeid;

	@Column(name = "EmployeeContact")
	private String employeecontact;

	@Column(name = "EmployeeEmail")
	private String employeemail;

	@Column(name = "DateofBirth")
	private String doj;

	@Column(name = "Designation")
	private String designation;

	@ManyToOne
	private LoginVO companyLoginVO;

	@ManyToOne
	private LoginVO employeeLoginVO;

	@Column(name = "Status")
	private boolean status = true;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeecontact() {
		return employeecontact;
	}

	public void setEmployeecontact(String employeecontact) {
		this.employeecontact = employeecontact;
	}

	public String getEmployeemail() {
		return employeemail;
	}

	public void setEmployeemail(String employeemail) {
		this.employeemail = employeemail;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LoginVO getCompanyLoginVO() {
		return companyLoginVO;
	}

	public void setCompanyLoginVO(LoginVO companyLoginVO) {
		this.companyLoginVO = companyLoginVO;
	}

	public LoginVO getEmployeeLoginVO() {
		return employeeLoginVO;
	}

	public void setEmployeeLoginVO(LoginVO employeeLoginVO) {
		this.employeeLoginVO = employeeLoginVO;
	}

}
