package com.concerto.springbootmvc.complaintmanagementsystem.converter;

import org.springframework.stereotype.Component;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.ComplaintDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaint;

@Component
public class ComplaintConverter {

	private ComplaintConverter()
	{
		
	}
	
	public static Complaint convertDtoToEntity(ComplaintDTO complaintDTO)
	{
		Complaint complaints=new Complaint();
		complaints.setComplaintId(complaintDTO.getComplaintId());
		complaints.setComplaintDescription(complaintDTO.getComplaintDescription());
		complaints.setCustomer(complaintDTO.getCustomer());
		complaints.setSupport(complaintDTO.getSupport());
		return complaints;
	}
	
}
