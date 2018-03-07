package com.facebook.contacts.ccu.snapshot;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;

/* compiled from: priceAmountOffset */
public class ContactsUploadSnapshotIterators$SnapshotIterator extends CursorIterator<ContactsUploadSnapshot> {
    private final int f6287b;
    private final int f6288c;

    public ContactsUploadSnapshotIterators$SnapshotIterator(Cursor cursor) {
        super(cursor);
        this.f6287b = cursor.getColumnIndex("local_contact_id");
        this.f6288c = cursor.getColumnIndex("contact_hash");
    }

    public void close() {
        this.a.close();
    }

    protected final Object m6697a(Cursor cursor) {
        return new ContactsUploadSnapshot(cursor.getLong(this.f6287b), cursor.getString(this.f6288c));
    }
}
