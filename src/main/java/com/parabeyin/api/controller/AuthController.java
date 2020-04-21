package com.parabeyin.api.controller;
/* Created by Farhad on 2020-03-31 */

import com.parabeyin.api.entity.User;
import com.parabeyin.api.entity.dto.UserDto;
import com.parabeyin.api.entity.dto.UserReponseDto;
import com.parabeyin.api.entity.dto.UserUpdateDto;
import com.parabeyin.api.security.jwt.JwtUtil;
import com.parabeyin.api.service.UserService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserReponseDto> register(@Valid @RequestBody User user) {
        User newUser = userDetailsService.save(user);
        return new ResponseEntity<>(modelMapper.map(newUser, UserReponseDto.class), HttpStatus.CREATED);
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

    @RequestMapping(value = "/profile",  method = RequestMethod.GET)
    public ResponseEntity<UserReponseDto> profile() {
        User currentUser = userService.getLoggedInUser();
        return ResponseEntity.ok(modelMapper.map(currentUser, UserReponseDto.class));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody @Valid UserUpdateDto userUpdateDto) {

        User user = userService.getLoggedInUser();
        if(!validEmail(user.getId(), userUpdateDto.getEmail())) {
            return new ResponseEntity<>(
                    "This email already in use",
                    HttpStatus.BAD_REQUEST);
        }

        user.setFirstname(userUpdateDto.getFirstname());
        user.setLastname(userUpdateDto.getLastname());
        user.setEmail(userUpdateDto.getEmail());
        user.setBirthday(userUpdateDto.getBirthday());
        user.setGender(userUpdateDto.getGender());
        user = userService.update(user);

        return ResponseEntity.ok(modelMapper.map(user, UserReponseDto.class));
    }

    private boolean validEmail(long id, String email) {

        User user = userService.getUserByEmail(email);

        if(user == null || user.getId() == id) {
            return true;
        }

        return false;
    }

    private boolean validUsername(long id, String username) {

        User user = userService.getUserByUsername(username);

        if(user == null || user.getId() == id) {
            return true;
        }

        return false;
    }





}
