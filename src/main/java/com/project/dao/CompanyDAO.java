package com.project.dao;

import java.util.List;

import com.project.model.CompanyDetailsVO;
import com.project.model.CompanyVO;
import com.project.model.EmployeeVO;

public interface CompanyDAO {

	void saveCompany(CompanyVO companyvo);

	List<CompanyVO> viewCompany();

	List<CompanyVO> deleteCompany(int id);

	List<CompanyVO> findById(int id);
}
