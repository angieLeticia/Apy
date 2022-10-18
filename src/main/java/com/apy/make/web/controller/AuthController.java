package com.apy.make.web.controller;

import com.apy.make.domain.service.ApyUserDetailsServices;
import com.apy.make.dto.AuthenticaticionResponse;
import com.apy.make.dto.AuthenticationRequest;
import com.apy.make.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
     private AuthenticationManager authenticationManager;
    @Autowired
    private ApyUserDetailsServices apyUserDetailsServices;
    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticaticionResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            UserDetails userDetails = apyUserDetailsServices.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return  new ResponseEntity<>(new AuthenticaticionResponse(jwt),HttpStatus.OK);
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
