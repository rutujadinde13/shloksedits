package com.concerto.springbootmvc.complaintmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin/admindashboard")
	public String adminDashboard()
	{
		return "admindashboard";
	}
}
