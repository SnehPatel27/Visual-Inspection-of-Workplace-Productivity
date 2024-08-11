package com.project.service;

import java.util.List;

import com.project.model.FeedbackVO;

public interface FeedbackService {

	public void savefeedback(FeedbackVO feedbackvo);
	
	public List<FeedbackVO> viewfeedbacks(int id);
	
	public List<FeedbackVO> getfeedbacks();
	
	public List<FeedbackVO> feedbackById(int id);
}
