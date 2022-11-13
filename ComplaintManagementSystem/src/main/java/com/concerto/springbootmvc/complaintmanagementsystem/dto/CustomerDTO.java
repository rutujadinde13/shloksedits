package com.concerto.springbootmvc.complaintmanagementsystem.dto;

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
public class CustomerDTO {

	private int customerId;
	private String customerUsername;
	private String customerName;
	private String password;
	
	
}
