package com.concerto.springbootmvc.complaintmanagementsystem.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.CustomerDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.service.ComplaintService;
import com.concerto.springbootmvc.complaintmanagementsystem.service.CustomerService;

@Controller
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer/dashboard")
	public String customerdashboard(CustomerDTO customerDTO,Principal p,HttpSession httpSession) {
		Customer customer = this.customerService.getCustomerByUsername(p.getName());
		httpSession.setAttribute("customerid", customer.getCustomerId());
		return "dashboard";
	}

	@GetMapping("/customer/complaint")
	public String dashboard() {
		return "complaintpage";
	}

	@PostMapping("/customer/complaintAdd")
	public String addComplaint(ComplaintDTO complaintDTO,HttpSession httpSession) {
		int customerId=(Integer)httpSession.getAttribute("customerid");
		Customer customer=this.customerService.getCustomerById(customerId);
		complaintDTO.setCustomer(customer);

		Complaint complaint = this.complaintService.saveComplaint(complaintDTO);

		httpSession.setAttribute("id", complaint.getComplaintId());
		httpSession.setAttribute("desc",complaint.getComplaintDescription());
		httpSession.setAttribute("status",complaint.getSupport().getStatus());
		httpSession.setAttribute("comment",complaint.getSupport().getComments());

		return "complaintDesc";
	}

	@GetMapping("/customer/complaintstatus")
	public String complaintStatusPage(Principal principal) {

		return "complaintstatus";
	}

	@GetMapping("/customer/complaintDesc")
	public String getComplaintService() {
		return "complaintDesc";
	}

	@GetMapping("/customer/complainthistory")
	public String complaintHistory(HttpSession httpSession) {

		Integer customerId=(Integer)httpSession.getAttribute("customerid");

		Customer customer=this.customerService.getCustomerById(customerId);

		List<Complaint> complaintByCustomer = complaintService.getComplaintByCustomer(customer);

		httpSession.setAttribute("complaintList",complaintByCustomer);

		return "complaintHistory";
	}

	@GetMapping("/complaints")
	public String getAllComplaints(HttpSession httpSession){

		List<Complaint> allPendingComplaints =
				complaintService.getAllPendingComplaints("in process", "in process");

		httpSession.setAttribute("complaintList",allPendingComplaints);
		return "allComplaints";
	}
}
