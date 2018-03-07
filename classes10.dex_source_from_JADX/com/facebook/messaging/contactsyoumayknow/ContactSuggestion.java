package com.facebook.messaging.contactsyoumayknow;

import com.facebook.user.model.User;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: t8978355 */
public class ContactSuggestion {
    public final User f2078a;
    public final int f2079b;

    public ContactSuggestion(User user, int i) {
        this.f2078a = user;
        this.f2079b = i;
    }
}
