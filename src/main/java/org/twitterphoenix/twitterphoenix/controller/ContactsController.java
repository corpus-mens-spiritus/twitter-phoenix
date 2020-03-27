package org.twitterphoenix.twitterphoenix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twitterphoenix.twitterphoenix.domain.Contact;
import org.twitterphoenix.twitterphoenix.service.ContactsService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactsController {
    private ContactsService contactsService;

    @Autowired
    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getUserContacts() {
        return contactsService.getContacts();
    }
}
