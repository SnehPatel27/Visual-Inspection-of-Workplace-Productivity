package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CompanyVO;
import com.project.model.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(EmployeeVO employeevo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(employeevo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> viewEmployee(int id){
		List<EmployeeVO> ls = new ArrayList<EmployeeVO>();
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from EmployeeVO where companyLoginVO = "+id+" and status = true");
			ls = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> deleteEmployee(int id) {
		List<EmployeeVO> ls = new ArrayList<EmployeeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from EmployeeVO where id = " + id);
			ls = (List<EmployeeVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> findById(int id) {
		List<EmployeeVO> ls = new ArrayList<EmployeeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from EmployeeVO where status = true and id = " + id);
			ls = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyVO> getcompanyId(String userName){
		List<CompanyVO> ls = new ArrayList<CompanyVO>();
		try{
			Session session = sessionFactory.getCurrentSession();
			String selectQuery = "from CompanyVO where emailid = :usernameParam";
			Query query = session.createQuery(selectQuery);
			query.setParameter("usernameParam", userName);
			ls = query.list();
			System.out.println(ls);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public int getEmployeeCount(int companyId){
		int employeeCount=0;
			
		try {
			Session session = sessionFactory.getCurrentSession();
			String selectQuery = "select count(*) from EmployeeVO where status = true and companyLoginVO = "+companyId;
			Query query= session.createQuery(selectQuery);
			
			Long count = (Long)query.uniqueResult();
			
			System.out.println(":::"+count);
			employeeCount = count.intValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeCount;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List findByUsername(String userName){
		List ls = new ArrayList();
		try{
			Session session = sessionFactory.getCurrentSession();
			String selectQuery = "from EmployeeVO where EmployeeEmail  =  '"+userName+"'";
			Query query = session.createQuery(selectQuery);
			ls = query.list();
			System.out.println(ls);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

}
