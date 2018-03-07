package com.facebook.contacts.iterator;

import com.facebook.contacts.graphql.ContactLinkType;
import com.google.common.base.Function;

/* compiled from: persist_key */
class ContactCursors$2 implements Function<ContactLinkType, Integer> {
    final /* synthetic */ ContactCursors f8216a;

    ContactCursors$2(ContactCursors contactCursors) {
        this.f8216a = contactCursors;
    }

    public Object apply(Object obj) {
        return Integer.valueOf(((ContactLinkType) obj).getDbValue());
    }
}
