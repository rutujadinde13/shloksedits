package com.concerto.springbootmvc.complaintmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;

//Customer Repository to connect with database
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// Find a Customer with customer username in a database
	public Optional<Customer> findByCustomerUsername(String username);

	// check whether the customer username is present in the database or not
	public boolean existsByCustomerUsername(String username);

	// check whether the customer contact is present in the database or not
	public boolean existsByContact(String contact);

	// check whether the customer email is present in the database or not
	public boolean existsByEmail(String email);
}
