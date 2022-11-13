package com.concerto.springbootmvc.complaintmanagementsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.CustomerDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/customer/register")
	public String registerPage()
	{
		return "register";
	}
	
	@GetMapping("/loginuser")
	public String login(HttpSession http) {
		return "loginpage";
	}
	
	
	@PostMapping("/customer/register")
	public String registerCustomer(CustomerDTO customerDTO)
	{
		System.out.println(customerDTO);
		
		if(this.customerService.saveCustomer(customerDTO))
			return "redirect:/loginuser";
		return "index";
	}
}
