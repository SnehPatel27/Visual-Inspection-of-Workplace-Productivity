package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CompanyDAO;
import com.project.model.CompanyDetailsVO;
import com.project.model.CompanyVO;
import com.project.model.EmployeeVO;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companydao;

	@Override
	public void saveCompany(CompanyVO companyvo) {
		this.companydao.saveCompany(companyvo);
	}

	@Override
	public List<CompanyVO> viewCompany() {
		return (this.companydao.viewCompany());
	}

	@Override
	public List<CompanyVO> deleteCompany(int id) {
		return (this.companydao.deleteCompany(id));
	}

	@Override
	public List<CompanyVO> findById(int id) {
		return this.companydao.findById(id);
	}
}
