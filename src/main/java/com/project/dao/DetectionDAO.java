package com.project.dao;

import java.util.List;

public interface DetectionDAO {

	public List getdetectiondetails(Integer companyLoginId);
	
	int getDetectionCount();
}
