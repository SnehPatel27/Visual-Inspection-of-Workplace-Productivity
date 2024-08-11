package com.project.dao;

import java.util.List;

import com.project.model.CompanyVO;
import com.project.model.EmployeeVO;

public interface EmployeeDAO {

	 public void addEmployee(EmployeeVO employeevo);
	 
	 public List<EmployeeVO> viewEmployee(int id);
	 
	 public List<EmployeeVO> deleteEmployee(int id);
	 
	 public List<EmployeeVO> findById(int id);

	 public List<CompanyVO> getcompanyId(String userName);
	 
	 int getEmployeeCount(int companyId);
	 
	 public List findByUsername(String userName);
}
