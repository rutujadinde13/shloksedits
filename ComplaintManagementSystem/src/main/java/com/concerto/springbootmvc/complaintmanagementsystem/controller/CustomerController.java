package com.concerto.springbootmvc.complaintmanagementsystem.controller;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpSession;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.ResponseData;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.CustomerDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.service.CustomerService;

//Customer Controller 
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/customer/register")
	public String registerPage() {
		return "register";
	}

	// Login Page
	@GetMapping("/loginuser")
	public String login(@RequestParam(required = false, name = "error") String errorMsg, Model m) {

		if (errorMsg != null) {
			m.addAttribute("errorMsg", "Invalid Credentials");
			return "loginpage";
		}
		return "loginpage";
	}

	// Register Page
	@PostMapping("/customer/register")
	public String registerCustomer(CustomerDTO customerDTO) {
		System.out.println(customerDTO);
		try {
			this.customerService.saveCustomer(customerDTO);
			return "redirect:/loginuser";

		} catch (EntityExistsException e) {
			return "redirect:register?error=" + e.getMessage();
		}
	}

	@RequestMapping("/profile")
	public String profile(@RequestParam("customerId") int customerId, Model model, HttpSession httpSession){

		Customer customer = customerService.getCustomerById(customerId);

		model.addAttribute("customer", customer);
		model.addAttribute("noOfComplaints", customer.getComplaints().size());
		System.out.println("Profile has shown");

		return "profile";
	}

	@RequestMapping("/editprofile")
	public String editProfile(@RequestParam("customerId") int customerId, Model model){

		System.out.println("Edit Profile Controller");
		Customer customer = customerService.getCustomerById(customerId);

		model.addAttribute("customer", customer);
		return "editprofile";
	}

//	@PostMapping("/updateprofile")
//	public @ResponseBody ResponseData<String> updateProfile(){
//		System.out.println("Update Profile Controller");
//
//		return new ResponseData<>("success");
//	}

	@GetMapping("/updateprofile")
	public String updateProfile(){

		System.out.println("Update Profile Controller");

		return "dashboard";
	}
}
