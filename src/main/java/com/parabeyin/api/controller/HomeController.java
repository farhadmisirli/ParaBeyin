package com.parabeyin.api.controller;
/* Created by Farhad on 2020-04-01 */

import com.parabeyin.api.entity.User;
import com.parabeyin.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> users() {
        return  ResponseEntity.ok(userService.getAllUsers());
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity<String> currentUser() {

        User user = userService.getLoggedInUser();
        String username = user.getFirstname()+" "+user.getLastname();
        return ResponseEntity.ok("I got your message!"+username);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome message here..");
    }
}
