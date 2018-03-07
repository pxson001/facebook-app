package com.facebook.contacts.handlers;

import com.facebook.contacts.properties.ContactsStorageMode;

/* compiled from: phonetic_first_name */
/* synthetic */ class AddContactHandler$1 {
    static final /* synthetic */ int[] f8209a = new int[ContactsStorageMode.values().length];

    static {
        try {
            f8209a[ContactsStorageMode.CONTACTS_DATABASE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8209a[ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
