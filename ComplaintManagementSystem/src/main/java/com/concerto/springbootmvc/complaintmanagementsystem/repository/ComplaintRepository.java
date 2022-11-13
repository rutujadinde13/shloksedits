package com.concerto.springbootmvc.complaintmanagementsystem.repository;

import java.util.List;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

	List<Complaint> findByCustomer(Customer customer);

    List<Complaint> findBySupport();

    List<Complaint> findByStatusContainingAndCommentsContaining(String status, String comments);
}
