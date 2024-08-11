package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DetectionDAOImpl implements DetectionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List getdetectiondetails(Integer companyLoginId) {
		List list = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from DetectionVO where company_id = "+companyLoginId);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getDetectionCount(){
		int detectionCount=0;
		try {
			Session session = sessionFactory.getCurrentSession();
			String selectQuery = "select count(*) from DetectionVO";
			Query query= session.createQuery(selectQuery);
			Long count= (Long)query.uniqueResult();
			System.out.println(":::"+count);
			detectionCount=count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Long l= new Long(10);  
		int i=l.intValue();  
		
		 
		return detectionCount; 
	}
}
