package com.concerto.springbootmvc.complaintmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.ComplaintRepository;

//Admin Service
@Service
public class AdminService {

	@Autowired
	private ComplaintRepository complaintRepository;

	// getting list of all the pending complaints
	public List<Complaints> getAllPendingComplaints() {

		return complaintRepository.findBySupport();
	}

	// Getting Complaints by primary key i.e. complaintId
	public Complaints getComplaintById(int complaintId) {
		Optional<Complaints> optcomplaint = this.complaintRepository.findById(complaintId);
		if (optcomplaint.isPresent()) {
			return optcomplaint.get();
		} else {
			return optcomplaint.orElseThrow(
					() -> new EntityNotFoundException("Entity with this Complaint ID not found" + complaintId));
		}
	}

	// Update the complaint
	public boolean updateComplaint(Complaints complaints) {

		if (this.complaintRepository.existsById(complaints.getComplaintId())) {
			this.complaintRepository.save(complaints);
			return true;
		}
		return false;
	}
}
