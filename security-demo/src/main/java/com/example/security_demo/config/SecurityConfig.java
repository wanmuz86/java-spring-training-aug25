package com.example.security_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // This is the configuration file (that will be loaded upon start up)
@EnableWebSecurity // Activate Spring security setup
public class SecurityConfig {

	
	// Aspect Oriented Programming 
	// When the request arrives to the server
	// It will be intercepted , and verification / filter will be performed
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.
		authorizeHttpRequests(auth->
		auth.requestMatchers("/api/admin/**").hasRole("ADMIN")
		.requestMatchers("/api/todos").hasAnyRole("USER")
		.requestMatchers("/api/**").authenticated() // For all url that started with /api/ -> authenticated
		.anyRequest().permitAll() // The other request -> allow it
		)
		.httpBasic(Customizer.withDefaults())
		.csrf(csrf-> csrf.disable());  // Disable CSRF protection ->  To allow testing on Postman / disabled CSRF protection
		return http.build();
	}
	
	
	@Bean
	public UserDetailsService users() {
		
		// Create a mock user with the following username, password and roles = user
		// THis will be replaced with IAM next week
		// Or refer to last project code to create User from API
		
		UserDetails user = User.builder()
				.username("apiuser")
				.password("{noop}password123")  // No need to encrypt yet (mock data)
				.roles("USER")
				.build();
		
		// Create another mock user, with following username, password and roles = admin
		
		UserDetails admin = User.builder()
				.username("admin")
				.password("{noop}admin123")
				.roles("ADMIN")
				.build();
		
				return new InMemoryUserDetailsManager(user,admin);
		
	}
}
