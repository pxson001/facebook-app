package com.facebook.contacts.iterator;

import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.omnistore.ContactTranscription;
import com.facebook.omnistore.Cursor;
import javax.annotation.Nullable;

/* compiled from: pending_send_on_startup */
public class ContactOmnistoreIterator implements ContactIterator {
    boolean f8224a = true;
    private final Cursor f8225b;
    @Nullable
    private Contact f8226c = null;

    public ContactOmnistoreIterator(Cursor cursor) {
        this.f8225b = cursor;
    }

    public void close() {
        this.f8225b.close();
    }

    public void remove() {
        throw new UnsupportedOperationException(getClass().toString() + " does not support remove()");
    }

    public boolean hasNext() {
        if (this.f8224a) {
            m12063b();
        }
        return this.f8226c != null;
    }

    public Object next() {
        if (this.f8224a) {
            m12063b();
        }
        this.f8224a = true;
        return this.f8226c;
    }

    private void m12063b() {
        this.f8224a = false;
        this.f8226c = this.f8225b.step() ? ContactTranscription.m12133a(this.f8225b.getBlob()) : null;
    }
}
