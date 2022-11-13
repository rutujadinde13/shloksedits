package com.concerto.springbootmvc.complaintmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.CustomerRepository;

@SpringBootApplication
public class ComplaintManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintManagementSystemApplication.class, args);
	}

	@Autowired
	CustomerRepository customerRepository;

	
//	@Bean
	public void initailzie() {
		PasswordEncoder delegatingPasswordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		Customer customer=new Customer(2, "dani", "dani123",delegatingPasswordEncoder.encode("123") , null, "ROLE_ADMIN");
		this.customerRepository.save(customer);
	}
	
}
