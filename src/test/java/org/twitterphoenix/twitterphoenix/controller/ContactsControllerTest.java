package org.twitterphoenix.twitterphoenix.controller;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.twitterphoenix.twitterphoenix.domain.Contact;
import org.twitterphoenix.twitterphoenix.service.ContactsService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsController.class)
public class ContactsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContactsService contactsService;

    @Test
    public void getsTheListOfContacts() throws Exception {
        Contact contact = Contact.builder().id("@user").build();
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);

        when(contactsService.getContacts()).thenReturn(contacts);

        mvc.perform(get("/contacts")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is("@user")));
    }
}
