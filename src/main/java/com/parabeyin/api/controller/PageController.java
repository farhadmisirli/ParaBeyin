package com.parabeyin.api.controller;
/* Created by Farhad on 2020-04-15 */

import com.parabeyin.api.entity.Faq;
import com.parabeyin.api.entity.Page;
import com.parabeyin.api.entity.dto.ContactDto;
import com.parabeyin.api.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public ResponseEntity<List<Faq>> getFaqList() {
        return ResponseEntity.ok(pageService.findFaqsByActive(true));
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ResponseEntity<String> contact(@Valid @RequestBody ContactDto contactDto) {
        return ResponseEntity.ok("Success");
    }

    @RequestMapping(value = "/{slug}", method = RequestMethod.GET)
    public ResponseEntity<Page> getPage(@PathVariable String slug) {
        Page page = pageService.findBySlugAndActive(slug, true);
        if(page != null) {
            return ResponseEntity.ok(pageService.findBySlugAndActive(slug, true));
        }
        return new ResponseEntity("Page Not Found",HttpStatus.NOT_FOUND);
    }



}
