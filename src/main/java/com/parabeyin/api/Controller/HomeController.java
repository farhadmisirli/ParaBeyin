package com.parabeyin.api.Controller;
/* Created by Farhad on 2020-03-29 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello world");
    }

}
