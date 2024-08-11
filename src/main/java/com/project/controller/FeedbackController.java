package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.FeedbackVO;
import com.project.model.LoginVO;
import com.project.service.FeedbackService;
import com.project.service.LoginService;
import com.project.util.Basemethods;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackservice;

	@Autowired
	private LoginService loginservice;

	@GetMapping(value = "user/postFeedback")
	public ModelAndView manageFeedbacks() {
		return new ModelAndView("company/postFeedback", "feedback", new FeedbackVO());
	}

	@PostMapping(value = "user/savefeedback")
	public ModelAndView savefeedback(@ModelAttribute FeedbackVO feedbackvo) {

		String userName = Basemethods.getUserName();

		List<LoginVO> loginVOList = this.loginservice.findByUserName(userName);
		feedbackvo.setLoginvo(loginVOList.get(0));

		this.feedbackservice.savefeedback(feedbackvo);
		return new ModelAndView("redirect:postFeedback");
	}

	@GetMapping(value = "user/viewFeedback")
	public ModelAndView viewFeedbacks() {
		
		List<LoginVO> LoginVOList = new ArrayList<LoginVO>();
		List<FeedbackVO> FeedbackVOList = new ArrayList<FeedbackVO>();
		
		String userName = Basemethods.getUserName();
		LoginVOList = this.loginservice.findByUserName(userName);
		
		FeedbackVOList = this.feedbackservice.viewfeedbacks(LoginVOList.get(0).getId());
		
		return new ModelAndView("company/viewFeedback", "list", FeedbackVOList);
	}

	@GetMapping(value = "user/deleteFeedback")
	public ModelAndView deleteFeedback(@ModelAttribute FeedbackVO feedbackvo,@RequestParam int id){
		List<FeedbackVO> list = new ArrayList<FeedbackVO>();
		list = this.feedbackservice.feedbackById(id);
		feedbackvo = list.get(0);
		feedbackvo.setStatus(false);
		this.feedbackservice.savefeedback(feedbackvo);
		return new ModelAndView("redirect:/user/viewFeedback");
	}
}
