package com.concerto.springbootmvc.complaintmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.springbootmvc.complaintmanagementsystem.converter.ComplaintConverter;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Support;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.ComplaintRepository;

//Complaint Service 
@Service
public class ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	// Save the complaint Data in the database
	public Complaints saveComplaint(ComplaintDTO complaintDTO) {

		Complaints complaints = ComplaintConverter.convertDtoToEntity(complaintDTO);
		Support support = new Support();
		support.setStatus("in process");
		support.setComments("in process");
		complaints.setSupport(support);

		return this.complaintRepository.save(complaints);

	}

	// Getting the list of complaints by customer id
	public List<Complaints> getComplaintByCustomer(Customer customer) {
		return complaintRepository.findByCustomer(customer);
	}

	// Getting the list of complaint status
	public List<Complaints> getCustomerComplaintStatus(Customer customer) {
		return complaintRepository.findCutsomerByStatus(customer);
	}

	// getting last complaint from database
	public Complaints getLastComplaint() {
		return this.complaintRepository.findLastComplaint();
	}

}
