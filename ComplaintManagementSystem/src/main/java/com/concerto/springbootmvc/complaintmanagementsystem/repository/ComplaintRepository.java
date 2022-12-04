package com.concerto.springbootmvc.complaintmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;

//Complaint Repository to connect with database
public interface ComplaintRepository extends JpaRepository<Complaints, Integer> {

	// Find Complaints by Customer
	List<Complaints> findByCustomer(Customer customer);

	// find unsolved Complaints for Admin Login
	@Query(nativeQuery = true, value = "select * from Complaints where comments='in process' AND status='in process'")
	List<Complaints> findBySupport();

	// find complaints for customer which track for unsolved complaints
	@Query(nativeQuery = true, value = "select * from Complaints where comments='in process' AND status='in process' AND customerid=?")
	public List<Complaints> findCutsomerByStatus(Customer customer);

	// find last complaint from the database
	@Query(nativeQuery = true, value = "SELECT * FROM Complaints WHERE complaintId=(SELECT MAX(complaintId) FROM Complaints)")
	public Complaints findLastComplaint();

}
