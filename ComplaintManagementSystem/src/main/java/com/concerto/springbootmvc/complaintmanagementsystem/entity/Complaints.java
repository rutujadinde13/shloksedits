package com.concerto.springbootmvc.complaintmanagementsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//Complaint entity class 
@Entity
public class Complaints implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// complaint Id as primary key
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int complaintId;

	@Column(length = 150)
	private String complaintDescription;

	// Support class will now be embedded in your class as a field
	@Embedded
	private Support support;

	// customer Id is foreign key
	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "planId", nullable = false)
	private Plan plan;

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

	public Complaints(int complaintId, String complaintDescription, Support support, Customer customer, Plan plan) {
		super();
		this.complaintId = complaintId;
		this.complaintDescription = complaintDescription;
		this.support = support;
		this.customer = customer;
		this.plan = plan;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Complaints() {
		super();

	}

}
