package org.twitterphoenix.twitterphoenix.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsController.class)
public class ContactsControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getsTheListOfContacts() throws Exception {
        mvc.perform(get("/contacts")
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
    }
}
