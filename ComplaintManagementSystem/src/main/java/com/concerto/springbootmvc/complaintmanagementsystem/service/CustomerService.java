package com.concerto.springbootmvc.complaintmanagementsystem.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.concerto.springbootmvc.complaintmanagementsystem.converter.CustomerConverter;
import com.concerto.springbootmvc.complaintmanagementsystem.dto.CustomerDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public boolean saveCustomer(CustomerDTO customerDTO) {
		try {

			PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

			Customer customer = CustomerConverter.convertDtoToEntity(customerDTO);
			customer.setRoles("ROLE_CUSTOMER");
			customer.setPassword(delegatingPasswordEncoder.encode(customer.getPassword()));

			System.out.println(customer);
			if (this.customerRepository.existsByCustomerUsername(customer.getCustomerUsername())) {
				throw new EntityNotFoundException("Customer Username is already exists");
			}
			this.customerRepository.save(customer);

			return customerDTO != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public Customer getCustomerByUsername(String username)throws EntityNotFoundException
	{
		Optional<Customer> optionalCustometr=this.customerRepository.findByCustomerUsername(username);
		if(optionalCustometr.isPresent()) {
			return optionalCustometr.get();
		}
		else {
			return optionalCustometr.orElseThrow(()->new EntityNotFoundException("Entity with this username not found" + username));
		}
	}
	
	
	public Customer getCustomerById(int id) {
		return this.customerRepository.findById(id).get();
	}
}
