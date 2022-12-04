package com.concerto.springbootmvc.complaintmanagementsystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Plan_Details")
public class Plan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int planId;

	private String planName;
	private String planProvider;
	private String planDescription;
	private String planDuration;
	private double planAmount;

	@OneToMany(mappedBy = "plan", fetch = FetchType.EAGER)
	private List<Complaints> complaints;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanProvider() {
		return planProvider;
	}

	public void setPlanProvider(String planProvider) {
		this.planProvider = planProvider;
	}

	public String getPlanDuration() {
		return planDuration;
	}

	public void setPlanDuration(String planDuration) {
		this.planDuration = planDuration;
	}

	public double getPlanAmount() {
		return planAmount;
	}

	public void setPlanAmount(double planAmount) {
		this.planAmount = planAmount;
	}

	public List<Complaints> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaints> complaints) {
		this.complaints = complaints;
	}

	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", planProvider=" + planProvider
				+ ", planDescription=" + planDescription + ", planDuration=" + planDuration + ", planAmount="
				+ planAmount + ", complaints=" + complaints + "]";
	}

	public Plan(int planId, String planName, String planProvider, String planDescription, String planDuration,
			double planAmount, List<Complaints> complaints) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planProvider = planProvider;
		this.planDescription = planDescription;
		this.planDuration = planDuration;
		this.planAmount = planAmount;
		this.complaints = complaints;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public Plan() {
		super();

	}

}
