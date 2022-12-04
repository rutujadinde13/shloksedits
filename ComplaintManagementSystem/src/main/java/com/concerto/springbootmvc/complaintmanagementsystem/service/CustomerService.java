package com.concerto.springbootmvc.complaintmanagementsystem.service;

import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.concerto.springbootmvc.complaintmanagementsystem.converter.CustomerConverter;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.CustomerDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.CustomerRepository;

//Customer Service
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// Save the Customer in the Database
	public boolean saveCustomer(CustomerDTO customerDTO) throws EntityExistsException {

		// Spring Security provides password encoding feature using the PasswordEncoder
		// interface
		PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		Customer customer = CustomerConverter.convertDtoToEntity(customerDTO);
		customer.setRoles("ROLE_CUSTOMER");
		customer.setPassword(delegatingPasswordEncoder.encode(customer.getPassword()));

		if (this.customerRepository.existsByCustomerUsername(customer.getCustomerUsername())) {
			throw new EntityExistsException("Customer Username is already exists");
		} else if (this.customerRepository.existsByContact(customer.getContact())) {
			throw new EntityExistsException("Customer Contact Details is already exists");
		} else if (this.customerRepository.existsByEmail(customer.getEmail())) {
			throw new EntityExistsException("Customer Email Id is already exists");
		} else {
			this.customerRepository.save(customer);
		}
		return customerDTO != null;
	}

	// Getting the customer by customer username
	public Customer getCustomerByUsername(String username) throws EntityNotFoundException {
		Optional<Customer> optionalCustomer = this.customerRepository.findByCustomerUsername(username);
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		} else {
			return optionalCustomer
					.orElseThrow(() -> new EntityNotFoundException("Entity with this username not found" + username));
		}
	}

	// Getting the customer by it's primary Id i.e. customerId
	public Customer getCustomerById(int id) {
		Optional<Customer> optionalCustomer = this.customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		} else {
			return optionalCustomer
					.orElseThrow(() -> new EntityNotFoundException("Entity with this Customer ID not found" + id));
		}
	}
}
