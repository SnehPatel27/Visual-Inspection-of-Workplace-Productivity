package com.project.dao;

import java.util.List;

import com.project.model.ComplaintVO;

public interface ComplainDAO {

	public void saveComplain(ComplaintVO complainvo);

	public List<ComplaintVO> viewcomplaint(int id);

	public List<ComplaintVO> viewAllComplain();

	public List<ComplaintVO> getReplyDetails(int id);
}
