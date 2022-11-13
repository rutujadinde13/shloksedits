package com.concerto.springbootmvc.complaintmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int complaintId;
	
	@Column(length = 150)
	private String complaintDescription;
	
	@Embedded
	private Support support;

	
	@ManyToOne
	@JoinColumn(name = "customerId",nullable = false)
	private Customer customer;

	@Override
	public String toString() {
		return "Complaints [complaintId=" + complaintId + ", complaintDescription=" + complaintDescription
				+ ", support=" + support + "]";
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Complaint(int complaintId, String complaintDescription, Support support, Customer customer) {
		super();
		this.complaintId = complaintId;
		this.complaintDescription = complaintDescription;
		this.support = support;
		this.customer = customer;
	}

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
