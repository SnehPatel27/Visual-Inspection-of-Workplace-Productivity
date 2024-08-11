package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ComplaintVO;

@Repository
public class ComplainDAOImpl implements ComplainDAO{

	@Autowired 
	private SessionFactory sessionfactory;
	
	public void saveComplain(ComplaintVO complainvo){
		try{
			Session session = sessionfactory.getCurrentSession();
			session.saveOrUpdate(complainvo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComplaintVO> viewcomplaint(int id){
		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		try{
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from ComplaintVO where loginvo_id = "+id+ "and complainstatus = true");
			list = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComplaintVO> viewAllComplain(){
		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		try{
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from ComplaintVO where complainstatus = true");
			list = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComplaintVO> getReplyDetails(int id){
		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		try{
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from ComplaintVO where id="+id+" and complainstatus = true");
			list = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
