package com.concerto.springbootmvc.complaintmanagementsystem.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.CustomerRepository;

//LoginUserDetailService which implements UserDetailsService interface is used to retrieve user-related data
@Service
public class LoginUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	// loadUserByUsername() which can be overridden to customize the process of
	// finding the user
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> optionalcustomer = this.customerRepository.findByCustomerUsername(username);

		if (optionalcustomer.isPresent()) {
			Optional<UserDetails> optionalUserDetail = optionalcustomer.map(user -> new User(user.getCustomerUsername(),
					user.getPassword(), Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
							.collect(Collectors.toList())));
			if (optionalUserDetail.isPresent()) {
				return optionalUserDetail.get();
			}
		}

		throw new UsernameNotFoundException("Username Not Found :" + username);
	}

}
