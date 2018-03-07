package com.facebook.contacts.picker;

import com.facebook.user.model.User;
import com.google.common.base.Strings;
import java.text.Collator;
import java.util.Comparator;

/* compiled from: polling_marker */
public class UserComparatorByName implements Comparator<User> {
    private final Collator f6496a = Collator.getInstance();

    public int compare(Object obj, Object obj2) {
        User user = (User) obj2;
        return this.f6496a.compare(Strings.nullToEmpty(((User) obj).k()), Strings.nullToEmpty(user.k()));
    }

    public UserComparatorByName() {
        this.f6496a.setStrength(0);
    }
}
