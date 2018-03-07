package com.facebook.events.invite;

import android.database.Cursor;
import android.util.Pair;
import com.facebook.contacts.database.ContactSerialization;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.iterator.ContactDatabaseCursorIterator;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: chatcolors */
public class InviteeIterator extends ContactDatabaseCursorIterator {
    private Cursor f17731b;

    @Inject
    public InviteeIterator(@Assisted Cursor cursor, ContactSerialization contactSerialization) {
        super(cursor, contactSerialization);
        this.f17731b = cursor;
    }

    public final Pair<String, Contact> m18060b() {
        return new Pair(this.f17731b.getString(1), (Contact) next());
    }
}
