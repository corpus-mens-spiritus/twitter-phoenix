package org.twitterphoenix.twitterphoenix.service;

import org.springframework.stereotype.Component;
import org.twitterphoenix.twitterphoenix.domain.Contact;
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ContactsService {
    public List<Contact> getContacts() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        IDs idsObject = twitter.getFollowersIDs(-1);

        do {
            long[] ids = idsObject.getIDs();

            Arrays.stream(ids)
                    .forEach(System.out::println);

        } while(idsObject.hasNext());

        return new ArrayList<>();
    }

    public void addContact(Contact contact) {

    }

    public void sendMessageToUser() {

    }
}
