package com.parabeyin.api.controller;
/* Created by Farhad on 2020-04-10 */

import com.parabeyin.api.entity.User;
import com.parabeyin.api.entity.dto.UserDto;
import com.parabeyin.api.entity.dto.UserReponseDto;
import com.parabeyin.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserReponseDto> profile() {
        User currentUser = userService.getLoggedInUser();
        UserReponseDto userResponseDto  = modelMapper.map(currentUser, UserReponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }




}
