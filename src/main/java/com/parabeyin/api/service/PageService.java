package com.parabeyin.api.service;
/* Created by Farhad on 2020-04-15 */

import com.parabeyin.api.entity.Contact;
import com.parabeyin.api.entity.Faq;
import com.parabeyin.api.entity.Page;
import com.parabeyin.api.repository.ContactRepository;
import com.parabeyin.api.repository.FaqRepository;
import com.parabeyin.api.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    FaqRepository faqRepository;

    @Autowired
    ContactRepository contactRepository;

    public Page findBySlugAndActive(String slug, boolean active) {
        return  pageRepository.findBySlugAndActive(slug, active);
    }

    public List<Faq> findFaqsByActive(boolean active) {
        return faqRepository.findByActive(active);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

}
