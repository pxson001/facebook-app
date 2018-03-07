package com.facebook.messaging.contacts.loader;

import com.facebook.messaging.contacts.loader.ContactsLoader.Result;

/* compiled from: mergeFrom(Message) can only merge messages of the same type. */
class ContactsLoader$3 implements Runnable {
    final /* synthetic */ Result f10211a;
    final /* synthetic */ ContactsLoader f10212b;

    ContactsLoader$3(ContactsLoader contactsLoader, Result result) {
        this.f10212b = contactsLoader;
        this.f10211a = result;
    }

    public void run() {
        if (this.f10212b.x != null) {
            this.f10212b.x.a(null, this.f10211a);
        }
    }
}
