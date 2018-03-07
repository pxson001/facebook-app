package com.facebook.contacts.ccu.snapshot;

/* compiled from: primary_payment_card_id */
public class ContactsUploadSnapshot {
    public final long f6283a;
    public final String f6284b;
    public ChangeType f6285c;

    /* compiled from: primary_payment_card_id */
    public enum ChangeType {
        ADD,
        UPDATE,
        REMOVE
    }

    public ContactsUploadSnapshot(long j, String str) {
        this.f6283a = j;
        this.f6284b = str;
    }

    public final ChangeType m6696a() {
        return this.f6285c;
    }
}
