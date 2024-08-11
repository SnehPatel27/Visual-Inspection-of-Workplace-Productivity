package com.project.dao;

import java.util.List;

import com.project.model.CompanyVO;

public interface AdminDAO {

	void saveCompany(CompanyVO companyvo);
	
	List<CompanyVO> viewCompany();
	
	List<CompanyVO> deleteCompany(int id);
	
	List<CompanyVO> findById(int id);
}
