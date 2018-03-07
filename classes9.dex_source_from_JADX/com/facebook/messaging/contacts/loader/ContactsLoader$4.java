package com.facebook.messaging.contacts.loader;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.user.model.User;
import java.util.Comparator;

/* compiled from: mergeFrom(Message) can only merge messages of the same type. */
class ContactsLoader$4 implements Comparator<User> {
    final /* synthetic */ ContactsLoader f10213a;

    ContactsLoader$4(ContactsLoader contactsLoader) {
        this.f10213a = contactsLoader;
    }

    public int compare(Object obj, Object obj2) {
        return StringLocaleUtil.a(((User) obj).k()).compareTo(StringLocaleUtil.a(((User) obj2).k()));
    }
}
