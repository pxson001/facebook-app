package com.facebook.messaging.sms.contacts;

import com.facebook.user.model.User;
import java.util.Comparator;

/* compiled from: is_cancelled */
class PhoneContactsLoader$1 implements Comparator<User> {
    final /* synthetic */ PhoneContactsLoader f12114a;

    PhoneContactsLoader$1(PhoneContactsLoader phoneContactsLoader) {
        this.f12114a = phoneContactsLoader;
    }

    public int compare(Object obj, Object obj2) {
        return Float.compare(((User) obj2).m, ((User) obj).m);
    }
}
