package com.facebook.contacts.iterator;

import com.facebook.common.collect.CloseableIterator;
import com.facebook.contacts.graphql.Contact;

/* compiled from: permanent_failure */
public interface ContactIterator extends CloseableIterator<Contact> {
    void close();
}
