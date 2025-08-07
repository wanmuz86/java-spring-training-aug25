package com.example.jwt_demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_demo.dto.AuthRequest;
import com.example.jwt_demo.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	

	private final AuthenticationManager authenticationManager;
	
	public AuthController( AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	
	// ResponseEntity is the best practice way to provide Http Response to user
	// Specify the code of response, 200,201, 204, 401,403
	// And specify the Data -> Response DTO
	// ? -> Generic
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
		
		// log user in via the AuthManager (Spring Security function)
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authRequest.getUsername(), authRequest.getPassword()
				)
				);
				
		// if ok -> generate Jwt token		
		String token = JwtUtil.generateToken(authentication);
		
		// return OK (200) with with the token
		return ResponseEntity.ok(Map.of("token",token));
		
	}
}
