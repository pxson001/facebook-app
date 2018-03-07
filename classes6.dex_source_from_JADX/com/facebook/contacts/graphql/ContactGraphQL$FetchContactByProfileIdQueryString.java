package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactByProfileIdQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchContactByProfileIdQueryString extends TypedGraphQlQueryString<FetchContactByProfileIdQueryModel> {
    public ContactGraphQL$FetchContactByProfileIdQueryString() {
        super(FetchContactByProfileIdQueryModel.class, false, "FetchContactByProfileIdQuery", "794d49a9e4c947fe044aa33988fb4d69", "user", "10154444360826729", RegularImmutableSet.a);
    }

    public final String m11756a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "2";
            case -1439844555:
                return "3";
            case -1102636175:
                return "0";
            case 693548892:
                return "1";
            default:
                return str;
        }
    }
}
