package com.facebook.events.invite;

import android.database.Cursor;
import com.facebook.contacts.database.ContactSerialization;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: chat_head_thread_view */
public class InviteeIteratorProvider extends AbstractAssistedProvider<InviteeIterator> {
    public final InviteeIterator m18061a(Cursor cursor) {
        return new InviteeIterator(cursor, ContactSerialization.a(this));
    }
}
