package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CompanyDetailsVO;
import com.project.model.CompanyVO;
import com.project.model.LoginVO;
import com.project.service.CompanyDetailService;
import com.project.util.Basemethods;

@Controller
public class CompanyDetailController {

	@Autowired
	private CompanyDetailService companydetailservice;

	@GetMapping(value = "user/manageCompany")
	public ModelAndView loadManageCompany(@ModelAttribute CompanyDetailsVO companydetailsvo) {

		String userName = Basemethods.getUserName();

		List<LoginVO> ls = this.companydetailservice.getloginId(userName);
		Integer id = (ls.get(0).getId());

		List<CompanyDetailsVO> list = this.companydetailservice.getdetaillist(id);

		if (list.isEmpty()) {
			return new ModelAndView("company/manageCompany", "companydetails", new CompanyDetailsVO());
		} else {
			companydetailsvo = list.get(0);
			return new ModelAndView("company/manageCompany", "companydetails", companydetailsvo);
		}
	}

	@PostMapping(value = "user/addCompanyDetails")
	public ModelAndView updateCompanyDetails(@ModelAttribute CompanyDetailsVO companydetailsvo) {

		String userName = Basemethods.getUserName();

		List<LoginVO> ls = this.companydetailservice.getloginId(userName);
		companydetailsvo.setLoginVO(ls.get(0));

		this.companydetailservice.updateCompanyDetails(companydetailsvo);

		return new ModelAndView("redirect:manageCompany");
	}
}
