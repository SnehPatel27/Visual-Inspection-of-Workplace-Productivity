package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FeedbackDAO;
import com.project.model.FeedbackVO;

@Service 
@Transactional
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDAO feedbackdao;
	
	@Override
	public void savefeedback(FeedbackVO feedbackvo){
		this.feedbackdao.savefeedback(feedbackvo);
	}
	
	@Override
	public List<FeedbackVO> viewfeedbacks(int id){
		return this.feedbackdao.viewfeedbacks(id);
	}
	
	@Override
	public List<FeedbackVO> getfeedbacks(){
		return this.feedbackdao.getfeedbacks();
	}
	
	@Override
	public List<FeedbackVO> feedbackById(int id){
		return this.feedbackdao.feedbackById(id);
	}
}
