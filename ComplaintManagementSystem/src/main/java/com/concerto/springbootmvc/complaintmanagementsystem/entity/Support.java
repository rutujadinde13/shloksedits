package com.concerto.springbootmvc.complaintmanagementsystem.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Support {

	private String status;
	private String comments;
	
	@Override
	public String toString() {
		return "Support [status=" + status + ", comments=" + comments + "]";
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

	public Support() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Support(String status, String comments) {
		super();
		this.status = status;
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}
}
