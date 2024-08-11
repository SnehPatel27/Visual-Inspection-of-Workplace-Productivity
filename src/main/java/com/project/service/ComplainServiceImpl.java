package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ComplainDAO;
import com.project.model.ComplaintVO;

@Service
@Transactional
public class ComplainServiceImpl implements ComplainService {

	@Autowired
	private ComplainDAO complaindao;

	@Override
	public void saveComplain(ComplaintVO complainvo) {
		this.complaindao.saveComplain(complainvo);
	}

	@Override
	public List<ComplaintVO> viewcomplaint(int id) {
		return this.complaindao.viewcomplaint(id);
	}

	@Override
	public List<ComplaintVO> viewAllComplain() {
		return this.complaindao.viewAllComplain();
	}

	@Override
	public List<ComplaintVO> getReplyDetails(int id) {
		return this.complaindao.getReplyDetails(id);
	}
}
