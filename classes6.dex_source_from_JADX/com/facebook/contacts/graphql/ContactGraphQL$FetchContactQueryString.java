package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchContactQueryString extends TypedGraphQlQueryString<ContactModel> {
    public ContactGraphQL$FetchContactQueryString() {
        super(ContactModel.class, false, "FetchContactQuery", "a65809c520c7e86c7eff52779f4d14d7", "node", "10154444360811729", RegularImmutableSet.a);
    }

    public final String m11757a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "2";
            case -1439844555:
                return "3";
            case 139876762:
                return "0";
            case 693548892:
                return "1";
            default:
                return str;
        }
    }
}
