package com.concerto.springbootmvc.complaintmanagementsystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	
	@Column(nullable = false,unique=true,length=15)
	private String customerUsername;
	
	@Column(nullable = false,length=25)
	private String customerName;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	private List<Complaint> complaints;
	
	private String roles;

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerUsername=" + customerUsername + ", customerName="
				+ customerName + ", password=" + password + ", complaints=" + complaints + ", roles=" + roles + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Customer(int customerId, String customerUsername, String customerName, String password,
					List<Complaint> complaints, String roles) {
		super();
		this.customerId = customerId;
		this.customerUsername = customerUsername;
		this.customerName = customerName;
		this.password = password;
		this.complaints = complaints;
		this.roles = roles;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
