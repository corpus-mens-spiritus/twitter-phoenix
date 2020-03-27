package org.twitterphoenix.twitterphoenix.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twitterphoenix.twitterphoenix.domain.Contact;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactsController {
    @GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getUserContacts() {
        return new ArrayList<>();
    }
}
