package com.facebook.contacts.handlers;

import com.facebook.contacts.properties.ContactsStorageMode;

/* compiled from: phoneNumer */
public /* synthetic */ class UpdateContactIsMessengerUserHandler$1 {
    public static final /* synthetic */ int[] f8212a = new int[ContactsStorageMode.values().length];

    static {
        try {
            f8212a[ContactsStorageMode.CONTACTS_DATABASE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8212a[ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
