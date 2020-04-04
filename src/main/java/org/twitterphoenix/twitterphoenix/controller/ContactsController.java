package org.twitterphoenix.twitterphoenix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.twitterphoenix.twitterphoenix.domain.Contact;
import org.twitterphoenix.twitterphoenix.service.ContactsService;
import twitter4j.TwitterException;

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
    public List<Contact> getUserContacts() throws TwitterException {
        return contactsService.getContacts();
    }

    @PostMapping(value = "/contact")
    public void addContact(Contact contact) {
        contactsService.addContact(contact);
    }

    @PutMapping(value = "/message/{id_user}")
    public void sendMessageToContact(@RequestParam(value = "id_user") String idUser) {
        contactsService.sendMessageToUser();
    }
}
