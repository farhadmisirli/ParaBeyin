package com.parabeyin.api.controller;
/* Created by Farhad on 2020-04-17 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getQuestion() {
        return ResponseEntity.ok("Return question");
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> checkQuestion(@RequestParam Long question_id) {
        return ResponseEntity.ok("Check Answer");
    }







}
