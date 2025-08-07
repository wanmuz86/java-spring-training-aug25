package com.example.jwt_demo.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

// The class that is reposible to create the JWT token -> After user successfully logged in
// and to validate the JWT token -> For each subsequent request of the user
public class JwtUtil {

	// BEST PRACTICE -> this information from the config file -> deployment/ best practice topic
	// Defining the secret key
   private static final String SECRET = "f3d92dj29d8fh3298fhs9238fhj29dj3"; // must be 32+ chars
   private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes()); // Changed to SecretKey
   
   // And the duration of the key
   private static final long EXPIRATION_MS = 3600000;
  
   
   // Create the token
   public static String generateToken(Authentication authentication) {
       
	   String username = authentication.getName(); // Retrieve the user information / username
       Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // the roles
       
       // Create the exp  (expired at) and iat (issued at )
       Date now = new Date();
       Date expiryDate = new Date(now.getTime() + EXPIRATION_MS);
   
       // Create the token
       return Jwts.builder()
               .subject(username) // add the user info
               .issuedAt(now) // add the iat
               .expiration(expiryDate) // add the exp
               .claim("roles", authorities.stream()   
                       .map(GrantedAuthority::getAuthority)
                       .collect(Collectors.toList())) // add the user roles
               .signWith(KEY)   //hash it
               .compact();  
   }
  

   // Verify/ validate the token
   public static Claims validateToken(String token) {
     
	   return Jwts.parser()
           .verifyWith(KEY)
           .build()
           .parseSignedClaims(token)
           .getPayload();
   }
}
