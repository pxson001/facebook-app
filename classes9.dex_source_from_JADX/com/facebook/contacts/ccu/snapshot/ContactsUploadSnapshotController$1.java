package com.facebook.contacts.ccu.snapshot;

import com.facebook.contacts.ccu.snapshot.ContactsUploadSnapshot.ChangeType;

/* compiled from: primary_device_change_payload */
/* synthetic */ class ContactsUploadSnapshotController$1 {
    static final /* synthetic */ int[] f6286a = new int[ChangeType.values().length];

    static {
        try {
            f6286a[ChangeType.ADD.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6286a[ChangeType.UPDATE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6286a[ChangeType.REMOVE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
