package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.FeedbackVO;
import com.project.service.FeedbackService;

@Controller
public class ManageFeedbackController {

	@Autowired
	private FeedbackService feedbackservice;

	@GetMapping(value = "admin/manageFeedback")
	public ModelAndView manageFeedbacks() {
		List<FeedbackVO> list = new ArrayList<FeedbackVO>();
		list = this.feedbackservice.getfeedbacks();
		return new ModelAndView("admin/manageFeedback", "list", list);
	}

	@GetMapping(value = "admin/deleteFeedback")
	public ModelAndView deleteFeedback(@ModelAttribute FeedbackVO feedbackvo, @RequestParam int id){
		List<FeedbackVO> list = new ArrayList<FeedbackVO>();
		list = this.feedbackservice.feedbackById(id);
		feedbackvo = list.get(0);
		feedbackvo.setStatus(false);
		this.feedbackservice.savefeedback(feedbackvo);
		return new ModelAndView("redirect:/admin/manageFeedback");
	}
}
