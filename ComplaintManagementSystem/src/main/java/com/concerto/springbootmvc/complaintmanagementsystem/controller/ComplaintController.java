package com.concerto.springbootmvc.complaintmanagementsystem.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintPlanDto;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.PlanRequestDto;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.ResponseData;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Plan;
import com.concerto.springbootmvc.complaintmanagementsystem.service.ComplaintService;
import com.concerto.springbootmvc.complaintmanagementsystem.service.CustomerService;
import com.concerto.springbootmvc.complaintmanagementsystem.service.PlanService;

//Complaint Controller
@Controller
@RequestMapping("/customer")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PlanService planService;

	// for avoiding duplication
	private static final String CUSTOMER_ID = "customerId";
	private static final String CUSTOMER_NAME="customerName";

	// Principal -> get the username of the logged in user
	@GetMapping("/dashboard")
	public String customerdashboard(Principal p, HttpSession httpSession) {
		Customer customer = this.customerService.getCustomerByUsername(p.getName());
		httpSession.setAttribute(CUSTOMER_ID, customer.getCustomerId());
		httpSession.setAttribute(CUSTOMER_NAME,customer.getCustomerName());// set the logged in customerId in httpsession
		return "dashboard";
	}

	@GetMapping("/complaint")
	public String dashboard(Model m) {
		m.addAttribute("plansName", this.planService.getAllPlansName());

		return "complaintpage";
	}

	// add a complaint in the database
	@PostMapping("/complaintAdd")
	public @ResponseBody ResponseData<String> addComplaint(@RequestBody ComplaintPlanDto complaintPlanDto,
			HttpSession httpSession) {

		
		int customerId = (Integer) httpSession.getAttribute(CUSTOMER_ID);
		Customer customer = this.customerService.getCustomerById(customerId);
		ComplaintDTO complaintDTO = new ComplaintDTO();
		complaintDTO.setComplaintDescription(complaintPlanDto.getComplaintDescription());

		Plan plan = this.planService.getPlanByDetails(complaintPlanDto.getPlanName(), complaintPlanDto.getPlanName(),
				complaintPlanDto.getPlanDuration());
		
		
		complaintDTO.setCustomer(customer);

		complaintDTO.setPlan(plan);

		this.complaintService.saveComplaint(complaintDTO);

		return new ResponseData<>("success");
	}

	@PostMapping("/planProvider")
	public @ResponseBody ResponseData<List<String>> getPlanProvider(@RequestBody String ajaxPlanName) {

		JSONObject json = new JSONObject(ajaxPlanName);
		String planName = json.getString("planName");

		List<String> planProviders = this.planService.getAllProviderByPlanName(planName);
		ResponseData<List<String>> res = new ResponseData<>();
		res.setMessage("SUCCESS");
		res.setData(planProviders);
		return res;
	}

	@PostMapping("/planDescription")
	public @ResponseBody ResponseData<List<String>> getplanDescription(@RequestBody String ajaxPlanProvider) {
		JSONObject json = new JSONObject(ajaxPlanProvider);
		String planProvider = json.getString("planProvider");

		List<String> planDescription = this.planService.getAllDescriptionByPlanProvider(planProvider);
		ResponseData<List<String>> responseData = new ResponseData<>();

		responseData.setData(planDescription);
		return responseData;
	}

	@PostMapping("/planDuration")
	public @ResponseBody ResponseData<List<String>> getPlanDuration(@RequestBody String ajaxPlanDescription) {
		JSONObject jsonObject = new JSONObject(ajaxPlanDescription);
		String planDescription = jsonObject.getString("planDescription");

		List<String> planDuration = this.planService.getAllDurationByPlanDescription(planDescription);
		ResponseData<List<String>> responseData = new ResponseData<>();

		responseData.setData(planDuration);
		return responseData;
	}

	@PostMapping("/planAmount")
	public @ResponseBody ResponseData<Double> getPlanAmount(@RequestBody PlanRequestDto planRequestDto) {

		Double planAmount = this.planService.getPlanByDetails(planRequestDto.getPlanName(),
				planRequestDto.getPlanProvider(), planRequestDto.getPlanDuration()).getPlanAmount();
		ResponseData<Double> responseData = new ResponseData<>();

		responseData.setData(planAmount);
		return responseData;
	}

	// Compliant status URL
	@GetMapping("/complaintstatus")
	public String complaintStatusPage(HttpSession httpSession, Model model) {

		int customerId = (Integer) httpSession.getAttribute(CUSTOMER_ID);
		Customer customer = this.customerService.getCustomerById(customerId);

		List<Complaints> statusOfComplaints = this.complaintService.getCustomerComplaintStatus(customer);
		model.addAttribute("complaintsStatusList", statusOfComplaints);

		return "complaintstatus";
	}

	// getting recent added complaint
	@GetMapping("/complaintDesc")
	public String getComplaintService(Model m) {
		m.addAttribute("complaints", this.complaintService.getLastComplaint());
		return "complaintDesc";
	}

	// Complaint History URL
	@GetMapping("/complainthistory")
	public String displayAllComplaints(HttpSession httpSession, Model model) {
		Integer customerId = (Integer) httpSession.getAttribute(CUSTOMER_ID);
		Customer customer = this.customerService.getCustomerById(customerId);

		List<Complaints> complaintByCustomer = complaintService.getComplaintByCustomer(customer);

		model.addAttribute("complaintList", complaintByCustomer);

		return "complaintHistory";
	}
}
