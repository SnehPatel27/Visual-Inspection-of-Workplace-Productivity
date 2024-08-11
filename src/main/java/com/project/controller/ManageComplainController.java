package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ComplaintVO;
import com.project.service.ComplainService;

@Controller
public class ManageComplainController {

	@Autowired
	private ComplainService complainservice;
	
	private int reply_id;

	@GetMapping(value = "admin/complainDetails")
	public ModelAndView complainDetails() {
		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		list = this.complainservice.viewAllComplain();
		return new ModelAndView("admin/complainDetails", "list", list);
	}
	
	@GetMapping(value = "admin/deleteComplain")
	public ModelAndView deleteComplain(@ModelAttribute ComplaintVO complaintvo, @RequestParam int id){
		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		list = this.complainservice.getReplyDetails(id);
		complaintvo = list.get(0);
		complaintvo.setComplainstatus(false);
		this.complainservice.saveComplain(complaintvo);
		return new ModelAndView("redirect:/admin/complainDetails");
	}

	@GetMapping(value = "admin/complainReply")
	public ModelAndView loadreply(@RequestParam int id) {
		reply_id = id;
		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		list = this.complainservice.getReplyDetails(id);
		return new ModelAndView("admin/complainReply", "replydetails", list.get(0));
	}

	@PostMapping(value = "admin/saveReply")
	public ModelAndView saveReply(@ModelAttribute ComplaintVO complaintvo) {

		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		list = this.complainservice.getReplyDetails(reply_id);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String complainreplydate = formatter.format(date);
		
		complaintvo.setLoginvo(list.get(0).getLoginvo());
		complaintvo.setComplaindate(list.get(0).getComplaindate());
		complaintvo.setComplainreplydate(complainreplydate);
		complaintvo.setStatus("Replied");
		
		this.complainservice.saveComplain(complaintvo);
		
		return new ModelAndView("redirect:complainDetails");
	}
}
