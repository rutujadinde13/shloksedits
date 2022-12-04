package com.concerto.springbootmvc.complaintmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.ComplaintRepository;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.CustomerRepository;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.PlanRepository;
import com.concerto.springbootmvc.complaintmanagementsystem.service.AdminService;

@SpringBootApplication
public class ComplaintManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintManagementSystemApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    PlanRepository planRepository;

    @Bean
    public void initialize() {

        // Admin data PasswordEncoder

        PasswordEncoder delegatingPasswordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Customer customer
                = new Customer(1, "admin123", "admin", "9989834564", "admin@system.in", null,
                delegatingPasswordEncoder.encode("123"), null, "ROLE_ADMIN");
        this.customerRepository.save(customer);

    }
}

