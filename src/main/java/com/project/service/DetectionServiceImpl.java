package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.DetectionDAO;

@Service
@Transactional
public class DetectionServiceImpl implements DetectionService {

	@Autowired
	private DetectionDAO detectiondao;
	
	@Override
	public List getdetectiondetails(Integer companyLoginId){
		return this.detectiondao.getdetectiondetails(companyLoginId);
	}
	
	public int getDetectionCount(){
		return this.detectiondao.getDetectionCount();
	}
}
