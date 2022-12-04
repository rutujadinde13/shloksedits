package com.concerto.springbootmvc.complaintmanagementsystem.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

//customer entity class
@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// customer Id as a primary key
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;

	@Column(nullable = false, unique = true, length = 15)
	private String customerUsername;

	@Column(nullable = false, length = 25)
	private String customerName;

	@Column(nullable = false, unique = true)
	private String contact;

	@Column(nullable = false, unique = true, length = 25)
	private String email;

	
	private Date dateOfBirth;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(nullable = false)
	private String password;

	// mapped a Complaint bean
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Complaints> complaints;

	private String roles;

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

	public List<Complaints> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaints> complaints) {
		this.complaints = complaints;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerUsername=" + customerUsername + ", customerName="
				+ customerName + ", contact=" + contact + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", password=" + password + ", complaints=" + complaints + ", roles=" + roles + "]";
	}

	public Customer(int customerId, String customerUsername, String customerName, String contact, String email,
			Date dateOfBirth, String password, List<Complaints> complaints, String roles) {
		super();
		this.customerId = customerId;
		this.customerUsername = customerUsername;
		this.customerName = customerName;
		this.contact = contact;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.complaints = complaints;
		this.roles = roles;
	}

	public Customer() {
		super();

	}

}
