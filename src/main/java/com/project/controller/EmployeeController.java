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

import com.project.model.EmployeeVO;
import com.project.model.LoginVO;
import com.project.service.EmployeeService;
import com.project.service.LoginService;
import com.project.util.Basemethods;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	
	@Autowired
	private LoginService loginservice;
	
	@GetMapping(value = "user/manageEmployee")
	public ModelAndView loadManageEmployee() {
		System.out.println("inside ManageEmployee");
		return new ModelAndView("company/manageEmployee", "employee", new EmployeeVO());
	}

	@PostMapping(value = "user/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute EmployeeVO employeevo) {
		
		LoginVO employeeLoginVO = new LoginVO();
		
		employeeLoginVO.setEnabled(1);
		employeeLoginVO.setRole("ROLE_EMPLOYEE");
		employeeLoginVO.setStatus(true);
		employeeLoginVO.setPassword("12345");
		employeeLoginVO.setUserName(employeevo.getEmployeemail());
		
		this.loginservice.save(employeeLoginVO);
		
		String userName = Basemethods.getUserName();
		
		List<LoginVO>  loginVOList = this.loginservice.findByUserName(userName);
		System.out.println(loginVOList);
		LoginVO companyLoginVO  = loginVOList.get(0);
		
		employeevo.setEmployeeLoginVO(employeeLoginVO);
		employeevo.setCompanyLoginVO(companyLoginVO);;
		
		this.employeeservice.addEmployee(employeevo);
		
		return new ModelAndView("redirect:manageEmployee");
	}

	@GetMapping(value = "user/viewEmployee")
	public ModelAndView viewEmployee() {
		
		String userName = Basemethods.getUserName();
		List<LoginVO>  loginVOList = this.loginservice.findByUserName(userName);
		Integer id = (loginVOList.get(0).getId());
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		list = this.employeeservice.viewEmployee(id);
		return new ModelAndView("company/viewEmployee", "list", list);
	}
	
	@GetMapping(value = "user/deleteEmployee")
	public ModelAndView deleteCompany(@ModelAttribute EmployeeVO employeevo, @RequestParam int id) {
		List<EmployeeVO> list = this.employeeservice.deleteEmployee(id);
		employeevo = list.get(0);
		employeevo.setStatus(false);
		this.employeeservice.addEmployee(employeevo);
		return new ModelAndView("redirect:/user/viewEmployee");
	}

	@GetMapping(value = "user/editEmployee")
	public ModelAndView editCompany(@ModelAttribute EmployeeVO employeevo, @RequestParam int id) {
		List<EmployeeVO> list = this.employeeservice.findById(id);
		System.out.println(list);
		employeevo = list.get(0);
		return new ModelAndView("company/manageEmployee", "employee", employeevo);
	}
}
