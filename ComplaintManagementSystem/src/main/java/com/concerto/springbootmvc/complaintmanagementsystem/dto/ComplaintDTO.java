package com.concerto.springbootmvc.complaintmanagementsystem.dto;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Status;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComplaintDTO {

	private int complaintId;
	private String complaintDescription;
	private Support support;
	private Customer customer;

}
