//package com.project.service;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.dao.AdminDAO;
//import com.project.model.CompanyVO;
//
//@Service
//@Transactional
//public class AdminServiceImpl implements AdminService {
//
//	@Autowired
//	private AdminDAO companydao;
//
//	@Override
//	public void saveCompany(CompanyVO companyvo) {
//		this.companydao.saveCompany(companyvo);
//	}
//
//	@Override
//	public List<CompanyVO> viewCompany() {
//		return (this.companydao.viewCompany());
//	}
//
//	@Override
//	public List<CompanyVO> deleteCompany(int id) {
//		return (this.companydao.deleteCompany(id));
//	}
//
//	@Override
//	public List<CompanyVO> findById(int id) {
//		return this.companydao.findById(id);
//	}
//}
