package com.concerto.springbootmvc.complaintmanagementsystem.converter;

import org.springframework.stereotype.Component;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.CustomerDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;

@Component
public class CustomerConverter {

	private CustomerConverter() {

	}

	// Convert Customer DTO to Customer Entity for further usage
	public static Customer convertDtoToEntity(CustomerDTO customerDTO) {

		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerUsername(customerDTO.getCustomerUsername());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setPassword(customerDTO.getPassword());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setContact(customerDTO.getContact());
		customer.setEmail(customerDTO.getEmail());
		return customer;

	}
}
