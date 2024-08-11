package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.EmployeeDAO;
import com.project.model.CompanyVO;
import com.project.model.EmployeeVO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeedao;

	@Override
	public void addEmployee(EmployeeVO employeevo) {
		this.employeedao.addEmployee(employeevo);
	}

	@Override
	public List<EmployeeVO> viewEmployee(int id) {
		return this.employeedao.viewEmployee(id);
	}

	@Override
	public List<EmployeeVO> deleteEmployee(int id) {
		return this.employeedao.deleteEmployee(id);
	}

	@Override
	public List<EmployeeVO> findById(int id) {
		return this.employeedao.findById(id);
	}

	@Override
	public List<CompanyVO> getcompanyId(String userName) {
		return this.employeedao.getcompanyId(userName);
	}

	public int getEmployeeCount(int companyId) {
		return this.employeedao.getEmployeeCount(companyId);
	}

	@Override
	public List findByUsername(String userName) {
		return this.employeedao.findByUsername(userName);
	}
}
