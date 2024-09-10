package com.example.SpringJWT.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.example.SpringJWT.boot.MyUserDetailsService;
import com.example.SpringJWT.model.AuthenticationRequest;
import com.example.SpringJWT.model.AuthenticationResponse;
import com.example.SpringJWT.util.JwtUtil;

@RestController
public class EmployeeResource {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtutil;
    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {

            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtutil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping
    @RequestMapping("/greet")
    public String greet() {
        return "working";
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    @RequestMapping("/admin")
    public String greetAdmin() {
        return "Admin@Work";
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    @RequestMapping("/user")
    public String greetUser() {
        return "User@Work";
    }
}
