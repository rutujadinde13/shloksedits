package com.concerto.springbootmvc.complaintmanagementsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintRequestDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.ResponseData;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Support;
import com.concerto.springbootmvc.complaintmanagementsystem.service.AdminService;
import com.concerto.springbootmvc.complaintmanagementsystem.service.ComplaintService;

//admin Controller
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	ComplaintService complaintService;

	// admin dashboard url
	@RequestMapping("/admindashboard")
	public String adminDashboard(HttpSession httpSession) {
		List<Complaints> allComplaints = this.adminService.getAllPendingComplaints();
		httpSession.setAttribute("listOfComplaints", allComplaints);
		return "admindashboard";
	}

	// update a complaint
	@RequestMapping("/updateComplaint")
	public String updateComplaint(@RequestParam("complaintId") int complaintId, Model model) {
		Complaints complaints = this.adminService.getComplaintById(complaintId);
		model.addAttribute("complaints", complaints);
		return "updateComplaint";
	}

	// update the complaint
	@PostMapping("/updateComplaint")
	public @ResponseBody ResponseData<String> updateForm(@RequestBody ComplaintRequestDTO complaintRequestDTO) {

		Complaints complaint = this.adminService.getComplaintById(complaintRequestDTO.getComplaintId());

		Support support = new Support();
		support.setComments(complaintRequestDTO.getComments());
		support.setStatus(complaintRequestDTO.getStatus());

		complaint.setSupport(support);

		this.adminService.updateComplaint(complaint);

		return new ResponseData<>("success");
	}
}
