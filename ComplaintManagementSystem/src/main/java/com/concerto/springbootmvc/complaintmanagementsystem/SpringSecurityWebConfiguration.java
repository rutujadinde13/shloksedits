package com.concerto.springbootmvc.complaintmanagementsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Configuration
@EnableWebSecurity
public class SpringSecurityWebConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private UserDetailsService detailsService;
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(detailsService);
	 * 
	 * }
	 */

	@Autowired
	private AuthenticationHandler authenticationHandler;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests()
		.antMatchers("/customer/dashboard","/customer/complaintstatus","/customer/complaint").hasRole("CUSTOMER")
		.antMatchers("/admin/admindashboard").hasRole("ADMIN")
		.antMatchers("/", "/customer/register").permitAll()
		.and().formLogin()
		.successHandler(authenticationHandler)
		.loginPage("/loginuser")
		.and().logout().permitAll();

	}
	
	
}
