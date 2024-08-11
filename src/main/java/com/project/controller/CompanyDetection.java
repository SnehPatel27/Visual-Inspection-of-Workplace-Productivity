package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.service.DetectionService;
import com.project.service.LoginService;
import com.project.util.Basemethods;

@Controller
public class CompanyDetection {

	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private DetectionService detectionService;
	
	
	@GetMapping(value="user/manageDetection")
	public ModelAndView loadCompanyDetection(){
	
		
		String userName = Basemethods.getUserName();

		List<LoginVO> loginVOList = this.loginservice.findByUserName(userName);
		LoginVO loginvo = loginVOList.get(0);

		List ls = detectionService.getdetectiondetails(loginvo.getId());
		
		System.out.println(ls.size());
		
		return new ModelAndView("company/manageDetection","detectionList",ls);
	}
	
	
	
}
