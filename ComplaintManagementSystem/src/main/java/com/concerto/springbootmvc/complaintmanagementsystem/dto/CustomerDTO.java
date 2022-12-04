package com.concerto.springbootmvc.complaintmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//customer DTO 
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

	private String contact;

	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

}
