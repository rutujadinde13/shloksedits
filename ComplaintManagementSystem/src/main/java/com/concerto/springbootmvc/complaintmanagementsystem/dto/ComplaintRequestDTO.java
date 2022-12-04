package com.concerto.springbootmvc.complaintmanagementsystem.dto;

//this class is used for update the Complaint from Admin side
public class ComplaintRequestDTO {

	private int complaintId;
	private String complaintDescription;
	private String status;
	private String comments;
	private int customerId;
	private int planId;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public ComplaintRequestDTO() {
		super();

	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public ComplaintRequestDTO(int complaintId, String complaintDescription, String status, String comments,
			int customerId, int planId) {
		super();
		this.complaintId = complaintId;
		this.complaintDescription = complaintDescription;
		this.status = status;
		this.comments = comments;
		this.customerId = customerId;
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "ComplaintRequestDTO [complaintId=" + complaintId + ", complaintDescription=" + complaintDescription
				+ ", status=" + status + ", comments=" + comments + ", customerId=" + customerId + ", planId=" + planId
				+ "]";
	}

}
