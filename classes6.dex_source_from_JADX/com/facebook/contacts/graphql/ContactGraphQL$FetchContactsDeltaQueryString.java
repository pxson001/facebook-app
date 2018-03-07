package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsDeltaQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchContactsDeltaQueryString extends TypedGraphQlQueryString<FetchContactsDeltaQueryModel> {
    public ContactGraphQL$FetchContactsDeltaQueryString() {
        super(FetchContactsDeltaQueryModel.class, false, "FetchContactsDeltaQuery", "5b5e791429d984e9510eb3b35f4ccc0d", "viewer", "10154444360801729", RegularImmutableSet.a);
    }

    public final String m11760a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "4";
            case -1439844555:
                return "5";
            case -713514397:
                return "1";
            case 92734940:
                return "0";
            case 102976443:
                return "2";
            case 693548892:
                return "3";
            default:
                return str;
        }
    }
}
