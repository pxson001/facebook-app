package com.facebook.contacts.iterator;

import com.facebook.contacts.properties.ContactsStorageMode;

/* compiled from: pending_story_delete_failed */
/* synthetic */ class ContactIterators$1 {
    static final /* synthetic */ int[] f8223a = new int[ContactsStorageMode.values().length];

    static {
        try {
            f8223a[ContactsStorageMode.CONTACTS_DATABASE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8223a[ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
