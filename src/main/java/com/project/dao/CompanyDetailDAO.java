package com.project.dao;

import java.util.List;

import com.project.model.CompanyDetailsVO;
import com.project.model.LoginVO;

public interface CompanyDetailDAO {

	public void updateCompanyDetails(CompanyDetailsVO companydetailsvo);

	public List<LoginVO> getloginId(String userName);

	public List<CompanyDetailsVO> getdetaillist(int id);
}
