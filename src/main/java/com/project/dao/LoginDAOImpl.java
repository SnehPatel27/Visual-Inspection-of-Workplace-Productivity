package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(LoginVO loginVO) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(loginVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginVO> findByUserName(String UserName) {
		System.out.println("inside DAO");
		List<LoginVO> list = new ArrayList<LoginVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			String selectQuery = "from LoginVO where userName = :usernameParam";
			Query query = session.createQuery(selectQuery);
			query.setParameter("usernameParam", UserName);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
	
	public int getCompanyCount(){
		int companyCount=0;

		try {
			Session session = sessionFactory.getCurrentSession();
			String selectQuery = "select count(*) from CompanyVO where status = true";
			Query query= session.createQuery(selectQuery);
			
			Long count = (Long)query.uniqueResult();
			
			System.out.println(":::"+count);
			companyCount = count.intValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return companyCount; 
	}
}
