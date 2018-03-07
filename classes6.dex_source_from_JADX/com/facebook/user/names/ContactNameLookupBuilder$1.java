package com.facebook.user.names;

import java.util.Comparator;

/* compiled from: control_node */
class ContactNameLookupBuilder$1 implements Comparator<String> {
    final /* synthetic */ ContactNameLookupBuilder f18459a;

    ContactNameLookupBuilder$1(ContactNameLookupBuilder contactNameLookupBuilder) {
        this.f18459a = contactNameLookupBuilder;
    }

    public int compare(Object obj, Object obj2) {
        return ((String) obj2).length() - ((String) obj).length();
    }
}
