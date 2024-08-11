package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ComplaintVO;
import com.project.model.LoginVO;
import com.project.service.ComplainService;
import com.project.service.LoginService;
import com.project.util.Basemethods;

@Controller
public class ComplaintController {

	@Autowired
	private ComplainService complainservice;

	@Autowired
	private LoginService loginservice;

	@GetMapping(value = "user/postComplain")
	public ModelAndView complainDetails() {
		return new ModelAndView("company/postComplain", "complain", new ComplaintVO());
	}

	@PostMapping(value = "user/saveComplaint")
	public ModelAndView saveComplain(@ModelAttribute ComplaintVO complainvo, @RequestParam MultipartFile file,
			HttpServletRequest request) {

		String userName = Basemethods.getUserName();

		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println("the path is :: " + path);
		String addProductFilePath = path + "\\complaint-docs\\";

		List<LoginVO> loginVOList = this.loginservice.findByUserName(userName);
		LoginVO loginvo = loginVOList.get(0);

		complainvo.setLoginvo(loginvo);
		complainvo.setStatus("Pending");

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String complaindate = formatter.format(date);
		complainvo.setComplaindate(complaindate);

		UUID uuid = UUID.randomUUID();

		StringTokenizer st = new StringTokenizer(file.getOriginalFilename(), ".");

		String extension = "";

		while (st.hasMoreTokens()) {
			extension = st.nextToken();
		}

		String addProductFileToInsert = uuid + "." + extension;
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(addProductFilePath + "/" + addProductFileToInsert));

			bout.write(barr);
			bout.flush();
			bout.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		complainvo.setFileName(addProductFileToInsert);
		complainvo.setFilePath(addProductFilePath + "/" + addProductFileToInsert);
		
		this.complainservice.saveComplain(complainvo);

		return new ModelAndView("redirect:postComplain");
	}

	@GetMapping(value = "user/viewComplain")
	public ModelAndView viewComplain() {
		List<ComplaintVO> list = new ArrayList<ComplaintVO>();
		System.out.println("Inside view Complain");
		String userName = Basemethods.getUserName();

		List<LoginVO> loginVOList = this.loginservice.findByUserName(userName);
		Integer id = loginVOList.get(0).getId();

		list = this.complainservice.viewcomplaint(id);

		return new ModelAndView("company/viewComplain", "Complainlist", list);
	}
	
	@GetMapping(value="user/deleteComplain")
	public ModelAndView deleteComplain(@ModelAttribute ComplaintVO complaintvo, @RequestParam int id){
		System.out.println("inside delete");
		List<ComplaintVO> list = this.complainservice.getReplyDetails(id);
		complaintvo = list.get(0);
		complaintvo.setComplainstatus(false);
		this.complainservice.saveComplain(complaintvo);
		return new ModelAndView("redirect:/user/viewComplain");
	}
}
