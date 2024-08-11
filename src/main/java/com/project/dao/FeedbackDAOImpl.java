package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.FeedbackVO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void savefeedback(FeedbackVO feedbackvo) {
		try {
			Session session = sessionfactory.getCurrentSession();
			session.saveOrUpdate(feedbackvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedbackVO> viewfeedbacks(int id) {
		List<FeedbackVO> list = new ArrayList<FeedbackVO>();
		try {
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from FeedbackVO where loginvo_id=" + id + " and status = true");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedbackVO> getfeedbacks() {
		List<FeedbackVO> list = new ArrayList<FeedbackVO>();
		try {
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from FeedbackVO where status = true");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FeedbackVO> feedbackById(int id) {
		List<FeedbackVO> list = new ArrayList<FeedbackVO>();
		try {
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from FeedbackVO where status = true and id = "+id);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
