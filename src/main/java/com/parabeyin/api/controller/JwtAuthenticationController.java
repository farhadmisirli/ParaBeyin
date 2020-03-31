package com.parabeyin.api.controller;
/* Created by Farhad on 2020-03-31 */


import com.parabeyin.api.entity.User;
import com.parabeyin.api.entity.dto.JwtRequest;
import com.parabeyin.api.entity.dto.JwtResponse;
import com.parabeyin.api.entity.dto.UserDTO;
import com.parabeyin.api.security.jwt.JwtTokenUtil;
import com.parabeyin.api.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;



    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        Optional<User> user =  userDetailsService.checkUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        if(!user.isPresent()) {
            //return new ResponseEntity("Username or password is incorrect", HttpStatus.BAD_REQUEST);
        }

        boolean checkUser = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        if(!checkUser) {
            return new ResponseEntity("Username or password is incorrect", HttpStatus.BAD_REQUEST);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private boolean authenticate(String username, String password) throws Exception {


        System.out.println("Here.. ");
        System.out.println(username+"   -    "+password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            return false;
            //throw new Exception("Invalid Username or Password");
        }

        return true;

//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
    }
}
