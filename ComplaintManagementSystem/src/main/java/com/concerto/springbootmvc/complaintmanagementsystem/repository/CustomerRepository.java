package com.concerto.springbootmvc.complaintmanagementsystem.repository;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.JpaRepository;


import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	public Optional<Customer> findByCustomerUsername(String username);
	
	public boolean existsByCustomerUsername(String username);
	
	

	
}
