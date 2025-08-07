package com.example.jwt_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// Aspect Oriented Programming 
	// When the request arrives to the server
	// It will be intercepted , and verification / filter will be performed
	// Test login API on /api/auth/login check JWT token should be created
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.
		authorizeHttpRequests(auth->
		auth.requestMatchers("/api/admin/**").hasRole("ADMIN")
//		.requestMatchers("/api/todos").hasRole("USER")
//		.requestMatchers("/api/**").authenticated() // For all url that started with /api/ -> authenticated
		.anyRequest().permitAll() // The other request -> allow it
		)
		.httpBasic(Customizer.withDefaults())
		.csrf(csrf-> csrf.disable());  // Disable CSRF protection ->  To allow testing on Postman / disabled CSRF protection
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
	    UserDetails admin = User.builder()
	        .username("admin")
	        .password("{noop}admin123")
	        .roles("ADMIN")
	        .build();
	    UserDetails user = User.builder()
	        .username("user")
	        .password("{noop}user123")
	        .roles("USER")
	        .build();
	    return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	    return config.getAuthenticationManager();
	}


}
