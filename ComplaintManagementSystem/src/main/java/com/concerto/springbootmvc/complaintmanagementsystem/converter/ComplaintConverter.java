package com.concerto.springbootmvc.complaintmanagementsystem.converter;

import org.springframework.stereotype.Component;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintRequestDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Support;

@Component
public class ComplaintConverter {

	private ComplaintConverter() {

	}

	// Convert Complaint DTO to Complaint Entity for further usage
	public static Complaints convertDtoToEntity(ComplaintDTO complaintDTO) {

		Complaints complaints = new Complaints();
		complaints.setComplaintId(complaintDTO.getComplaintId());
		complaints.setComplaintDescription(complaintDTO.getComplaintDescription());
		complaints.setCustomer(complaintDTO.getCustomer());
		complaints.setSupport(complaintDTO.getSupport());
		complaints.setPlan(complaintDTO.getPlan());
		return complaints;
	}

	// Convert ComplaintRequestDTO to entity for updating the complaints
	public static Complaints updateDataToEntity(ComplaintRequestDTO complaintRequestDTO) {
		Complaints complaints = new Complaints();
		Support support = new Support();
		support.setComments(complaintRequestDTO.getComments());
		support.setStatus(complaintRequestDTO.getStatus());
		Customer customer = new Customer();
		customer.setCustomerId(complaintRequestDTO.getCustomerId());

		complaints.setCustomer(customer);

		complaints.setComplaintId(complaintRequestDTO.getComplaintId());
		complaints.setComplaintDescription(complaintRequestDTO.getComplaintDescription());
		complaints.setSupport(support);
		return complaints;
	}
}
