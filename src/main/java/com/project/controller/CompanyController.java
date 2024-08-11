package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CompanyVO;
import com.project.model.LoginVO;
import com.project.service.CompanyService;
import com.project.service.LoginService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyservice;

	@Autowired
	private LoginService loginService;

	@GetMapping(value = "admin/addCompany")
	public ModelAndView addCompany() {
		return new ModelAndView("admin/addCompany", "CompanyVO", new CompanyVO());
	}

	// Insert Company
	@PostMapping(value = "admin/addCompany")
	public ModelAndView saveCompany(@ModelAttribute CompanyVO companyvo) {

		LoginVO loginVO = new LoginVO();
		loginVO.setEnabled(1);
		loginVO.setPassword("12345");
		loginVO.setRole("ROLE_USER");
		loginVO.setStatus(true);
		loginVO.setUserName(companyvo.getEmailid());

		this.loginService.save(loginVO);

		companyvo.setLoginVO(loginVO);

		this.companyservice.saveCompany(companyvo);

		return new ModelAndView("redirect:viewCompany");
	}

	@GetMapping(value = "admin/viewCompany")
	public ModelAndView viewCompany() {
		List<CompanyVO> ls = this.companyservice.viewCompany();
		return new ModelAndView("admin/viewCompany", "list", ls);
	}

	// Delete Company
	@GetMapping(value = "admin/deleteCompany")
	public ModelAndView deleteCompany(@ModelAttribute CompanyVO companyvo, @RequestParam int id) {
		List<CompanyVO> list = this.companyservice.deleteCompany(id);
		companyvo = list.get(0);
		companyvo.setStatus(false);
		this.companyservice.saveCompany(companyvo);
		return new ModelAndView("redirect:/admin/viewCompany");
	}

	@GetMapping(value = "admin/editCompany")
	public ModelAndView editCompany(@ModelAttribute CompanyVO companyvo, @RequestParam int id) {
		List<CompanyVO> list = this.companyservice.findById(id);
		companyvo = list.get(0);
		return new ModelAndView("admin/addCompany", "CompanyVO", companyvo);
	}
}
