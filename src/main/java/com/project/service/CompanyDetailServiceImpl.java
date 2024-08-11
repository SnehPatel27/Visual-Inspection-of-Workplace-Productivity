package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CompanyDetailDAO;
import com.project.model.CompanyDetailsVO;
import com.project.model.LoginVO;

@Service
@Transactional
public class CompanyDetailServiceImpl implements CompanyDetailService {

	@Autowired
	private CompanyDetailDAO companydetaildao;

	@Override
	public void updateCompanyDetails(CompanyDetailsVO companydetailsvo) {
		this.companydetaildao.updateCompanyDetails(companydetailsvo);
	}
	
	@Override
	public List<LoginVO> getloginId(String userName){
		return this.companydetaildao.getloginId(userName);
	}
	
	@Override
	public List<CompanyDetailsVO> getdetaillist(int id){
		return this.companydetaildao.getdetaillist(id);
	}
}
