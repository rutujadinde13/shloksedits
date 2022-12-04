package com.concerto.springbootmvc.complaintmanagementsystem.dto;

public class ResponseData<T> {
	private String message;
	private T data;

	
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseData [message=" + message + ", data=" + data + "]";
	}

	public ResponseData(String message) {
		super();
		this.message = message;
	}

	public ResponseData() {
		super();

	}
	
	
}
