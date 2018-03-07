package com.facebook.contacts.upload.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntry;

/* compiled from: tapped_about_info_blurb */
public class PhoneAddressBookSnapshotEntryIterator extends CursorIterator<PhoneAddressBookSnapshotEntry> {
    private final int f2211b;
    private final int f2212c;

    public PhoneAddressBookSnapshotEntryIterator(Cursor cursor) {
        super(cursor);
        this.f2211b = cursor.getColumnIndex("local_contact_id");
        this.f2212c = cursor.getColumnIndex("contact_hash");
    }

    protected final Object m2184a(Cursor cursor) {
        return new PhoneAddressBookSnapshotEntry(cursor.getLong(this.f2211b), cursor.getString(this.f2212c));
    }
}
