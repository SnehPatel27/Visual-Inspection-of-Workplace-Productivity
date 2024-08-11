package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.EmployeeVO;
import com.project.model.LoginVO;
import com.project.service.DetectionService;
import com.project.service.EmployeeService;
import com.project.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private DetectionService detectionService;
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginVO loginVO) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();

		int companyCount = this.loginService.getCompanyCount();
		int detectionCount = this.detectionService.getDetectionCount();
		
		return new ModelAndView("admin/index","companyCount",companyCount).addObject("detectionCount", detectionCount);
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex() {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		
		List<LoginVO> loginVOList = this.loginService.findByUserName(userName);
		System.out.println("::::"+loginVOList.get(0).getId());
		int employeeCount = this.employeeService.getEmployeeCount(loginVOList.get(0).getId());
		
		return new ModelAndView("company/index","employeeCount",employeeCount);
	}
	
	@RequestMapping(value = "/employee/index", method = RequestMethod.GET)
	public ModelAndView employeeIndex() {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		System.out.println(userName);
		
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		list = this.employeeService.findByUsername(userName);
		System.out.println(list);
		return new ModelAndView("employee/index", "employeeVO" , list.get(0));
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewUserDetails(ModelMap model, HttpServletResponse response, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
			request.getSession().setAttribute("tempStatus", "success");
			request.getSession().setAttribute("statusText", "Logout Successfully!");
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("login");
	}

}
