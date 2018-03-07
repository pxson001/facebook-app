package com.facebook.contacts.upload;

import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntry;

/* compiled from: tapped_follow_switcher_button */
public class ContactsUploadActionBuilder {
    public ActionType f2121a;
    public long f2122b;
    public PhonebookContact f2123c;
    public PhoneAddressBookSnapshotEntry f2124d;

    ContactsUploadActionBuilder() {
    }

    final ContactsUploadAction m2090a() {
        return new ContactsUploadAction(this.f2121a, this.f2122b, this.f2123c, this.f2124d);
    }
}
