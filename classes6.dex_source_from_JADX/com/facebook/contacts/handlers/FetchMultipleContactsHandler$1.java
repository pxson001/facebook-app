package com.facebook.contacts.handlers;

import com.facebook.contacts.properties.ContactsStorageMode;

/* compiled from: phone_model */
/* synthetic */ class FetchMultipleContactsHandler$1 {
    static final /* synthetic */ int[] f8211a = new int[ContactsStorageMode.values().length];

    static {
        try {
            f8211a[ContactsStorageMode.CONTACTS_DATABASE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8211a[ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
