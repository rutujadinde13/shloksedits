package com.concerto.springbootmvc.complaintmanagementsystem.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;



//support class can be embedded in Complaint class 
@Embeddable
public class Support implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String comments;
	
	@Override
	public String toString() {
		return "Support [status=" + status + ", comments=" + comments + "]";
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

	public Support() {
		super();

	}

	public Support(String status, String comments) {
		super();
		this.status = status;
		this.comments = comments;
	}
	
	
}
