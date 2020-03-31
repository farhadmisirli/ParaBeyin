package com.parabeyin.api.service;
/* Created by Farhad on 2020-03-30 */

import com.parabeyin.api.entity.DAOUser;
import com.parabeyin.api.entity.User;
import com.parabeyin.api.entity.dto.UserDTO;
import com.parabeyin.api.repository.UserDao;
import com.parabeyin.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println(username+" <===== username");
        //DAOUser user = userDao.findByUsername(username);
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        System.out.println("returned");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public DAOUser save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return null; //userRepository.save(newUser);
    }

    public Optional<User> checkUsernameAndPassword(String username, String password) {
        System.out.println(username+" -  "+bcryptEncoder.encode(password));
        return userRepository.findByUsernameAndPassword(username, bcryptEncoder.encode(password));
    }
}