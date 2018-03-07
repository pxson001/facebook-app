package com.facebook.contacts.upload.data;

import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntryChange.ChangeType;

/* compiled from: tapped_consume_action */
/* synthetic */ class ContactsUploadDbHandler$1 {
    static final /* synthetic */ int[] f2196a = new int[ChangeType.values().length];

    static {
        try {
            f2196a[ChangeType.ADD.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2196a[ChangeType.UPDATE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2196a[ChangeType.DELETE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
