package com.concerto.springbootmvc.complaintmanagementsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;
import com.concerto.springbootmvc.complaintmanagementsystem.excel.ComplaintExcel;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.ComplaintRepository;

//Excel controller
@Controller
public class ExcelController {

	@Autowired
	private ComplaintRepository complaintRepository;

	@GetMapping("/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		String fileName = "Complaint_History.xlsx";
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		List<Complaints> listComplaint = complaintRepository.findAll();
		ComplaintExcel exporter = new ComplaintExcel(listComplaint);
		exporter.export(response);

	}

}
