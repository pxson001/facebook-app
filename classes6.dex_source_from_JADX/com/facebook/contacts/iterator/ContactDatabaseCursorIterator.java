package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.contacts.database.ContactSerialization;
import com.facebook.contacts.graphql.Contact;
import com.facebook.debug.log.BLog;
import javax.annotation.Nullable;

/* compiled from: per_unit_price */
public class ContactDatabaseCursorIterator extends CursorIterator<Contact> implements ContactIterator {
    private static final Class<?> f8217b = ContactDatabaseCursorIterator.class;
    public final Cursor f8218c;
    private final ContactSerialization f8219d;

    @Nullable
    protected final Object m12059a(Cursor cursor) {
        try {
            return this.f8219d.a(this.f8218c.getString(0));
        } catch (Throwable e) {
            BLog.b(f8217b, e, "Error deserializing contact", new Object[0]);
            return null;
        }
    }

    public ContactDatabaseCursorIterator(Cursor cursor, ContactSerialization contactSerialization) {
        super(cursor);
        this.f8218c = cursor;
        this.f8219d = contactSerialization;
    }
}
