package com.facebook.contacts.handlers;

import com.facebook.contacts.properties.ContactsStorageMode;

/* compiled from: phone_public_hash */
public /* synthetic */ class DeleteContactHandler$1 {
    public static final /* synthetic */ int[] f8210a = new int[ContactsStorageMode.values().length];

    static {
        try {
            f8210a[ContactsStorageMode.CONTACTS_DATABASE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8210a[ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
