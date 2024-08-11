package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CompanyVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCompany(CompanyVO companyvo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(companyvo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyVO> viewCompany() {
		List<CompanyVO> ls = new ArrayList<CompanyVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CompanyVO where status = true");
			ls = (List<CompanyVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyVO> deleteCompany(int id) {
		List<CompanyVO> ls = new ArrayList<CompanyVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CompanyVO where id = " + id);
			ls = (List<CompanyVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyVO> findById(int id){
		List<CompanyVO> ls = new ArrayList<CompanyVO>();
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CompanyVO where status = true and id = "+id);
			ls = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
}
