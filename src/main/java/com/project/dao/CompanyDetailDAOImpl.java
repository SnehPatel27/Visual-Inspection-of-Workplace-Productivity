package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CompanyDetailsVO;
import com.project.model.LoginVO;

@Repository
public class CompanyDetailDAOImpl implements CompanyDetailDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void updateCompanyDetails(CompanyDetailsVO companydetailsvo) {
		try {
			Session session = sessionfactory.getCurrentSession();
			session.saveOrUpdate(companydetailsvo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginVO> getloginId(String userName) {
		List<LoginVO> list = new ArrayList<LoginVO>();
		try {
			Session session = sessionfactory.getCurrentSession();
			String selectQuery = "from LoginVO where userName = :usernameParam";
			Query query = session.createQuery(selectQuery);
			query.setParameter("usernameParam", userName);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyDetailsVO> getdetaillist(int id){
		List<CompanyDetailsVO> list = new ArrayList<CompanyDetailsVO>();
		try{
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from CompanyDetailsVO where loginVO_id = "+id);
			list = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
