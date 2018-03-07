package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchContactsByIdsQueryString extends TypedGraphQlQueryString<Map<String, ContactModel>> {
    public ContactGraphQL$FetchContactsByIdsQueryString() {
        super(ContactModel.class, true, "FetchContactsByIdsQuery", "20fc6de5af496d5c60798f99962fb80a", "nodes", "10154444360776729", RegularImmutableSet.a);
    }

    public final String m11758a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "2";
            case -1439844555:
                return "3";
            case 41212441:
                return "0";
            case 693548892:
                return "1";
            default:
                return str;
        }
    }
}
