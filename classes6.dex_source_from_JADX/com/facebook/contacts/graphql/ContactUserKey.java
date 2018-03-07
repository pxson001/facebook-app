package com.facebook.contacts.graphql;

import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet.Builder;

/* compiled from: phonetic_last_name */
public class ContactUserKey {
    public static ImmutableCollection<UserKey> m12037a(Contact contact) {
        boolean z = (contact.c() == null && contact.b() == null) ? false : true;
        Preconditions.checkArgument(z);
        Builder builder = new Builder();
        String c = contact.c();
        if (c != null) {
            builder.c(new UserKey(Type.FACEBOOK, c));
        }
        c = contact.b();
        if (c != null) {
            builder.c(new UserKey(Type.FACEBOOK_CONTACT, c));
        }
        return builder.b();
    }
}
