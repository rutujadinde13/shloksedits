package com.concerto.springbootmvc.complaintmanagementsystem.service;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.springbootmvc.complaintmanagementsystem.converter.ComplaintConverter;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaint;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Support;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.ComplaintRepository;

import java.util.List;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;
	
	
    public Complaint saveComplaint(ComplaintDTO complaintDTO)
    {
    	
    	Complaint complaints=ComplaintConverter.convertDtoToEntity(complaintDTO);
    	Support support=new Support();
		support.setStatus("in process");
		support.setComments("in process");
		complaints.setSupport(support);
    	System.out.println(complaints);
		return this.complaintRepository.save(complaints);
    }

	public List<Complaint> getComplaintByCustomer(Customer customer) {
		return complaintRepository.findByCustomer(customer);
	}

    public List<Complaint> getAllPendingComplaints(String status, String comments) {

		return complaintRepository.findByStatusContainingAndCommentsContaining(status,comments);
    }
}
