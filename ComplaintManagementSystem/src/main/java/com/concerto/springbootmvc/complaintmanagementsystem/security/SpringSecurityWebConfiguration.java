package com.concerto.springbootmvc.complaintmanagementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//web security configuration 
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SpringSecurityWebConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationHandler authenticationHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests()
				.antMatchers("/customer/dashboard", "/customer/complaintstatus", "/customer/complaint",
						"/customer/complaintHistory")
				.hasRole("CUSTOMER").antMatchers("/admin/admindashboard", "/admin/updateComplaint").hasRole("ADMIN")
				.antMatchers("/", "/customer/register").permitAll().and().formLogin()
				.successHandler(authenticationHandler).loginPage("/loginuser").and().logout().permitAll();

	}

}
