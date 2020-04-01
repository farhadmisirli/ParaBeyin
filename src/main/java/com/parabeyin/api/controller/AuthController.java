package com.parabeyin.api.controller;
/* Created by Farhad on 2020-03-31 */

import com.parabeyin.api.entity.User;
import com.parabeyin.api.entity.dto.UserDto;
import com.parabeyin.api.security.jwt.JwtUtil;
import com.parabeyin.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserService userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> generateToken(@RequestBody UserDto authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            return new ResponseEntity("Invalid username or password", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(jwtUtil.generateToken(authRequest.getUsername()));
    }

    // Refresh Token
    @RequestMapping(value = "/token/refresh", method = RequestMethod.POST)
    public ResponseEntity<String> refreshToken(@RequestBody String token) {
        return ResponseEntity.ok(token);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("logout success");
    }


}
