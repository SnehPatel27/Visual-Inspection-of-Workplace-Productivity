package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detectionvo")
public class DetectionVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "detection_id")
	private int id;

	@Column(name = "time_diff")
	private String timeDiff;

	@Column(name = "detection_datetime")
	private String detectionDateTime;

	@Column(name = "detection_status")
	private String detectionStatus;

	@Column(name = "face_count")
	private String faceCount;

	@Column(name = "detection_video")
	private String detectionVideo;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private LoginVO employeeVO;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private LoginVO companyVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(String timeDiff) {
		this.timeDiff = timeDiff;
	}

	public String getDetectionDateTime() {
		return detectionDateTime;
	}

	public void setDetectionDateTime(String detectionDateTime) {
		this.detectionDateTime = detectionDateTime;
	}

	public String getDetectionStatus() {
		return detectionStatus;
	}

	public void setDetectionStatus(String detectionStatus) {
		this.detectionStatus = detectionStatus;
	}

	public String getFaceCount() {
		return faceCount;
	}

	public void setFaceCount(String faceCount) {
		this.faceCount = faceCount;
	}

	public String getDetectionVideo() {
		return detectionVideo;
	}

	public void setDetectionVideo(String detectionVideo) {
		this.detectionVideo = detectionVideo;
	}

	public LoginVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(LoginVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public LoginVO getCompanyVO() {
		return companyVO;
	}

	public void setCompanyVO(LoginVO companyVO) {
		this.companyVO = companyVO;
	}

}
