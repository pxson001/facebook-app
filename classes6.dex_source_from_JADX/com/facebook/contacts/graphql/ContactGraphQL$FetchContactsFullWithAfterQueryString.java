package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsFullWithAfterQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchContactsFullWithAfterQueryString extends TypedGraphQlQueryString<FetchContactsFullWithAfterQueryModel> {
    public ContactGraphQL$FetchContactsFullWithAfterQueryString() {
        super(FetchContactsFullWithAfterQueryModel.class, false, "FetchContactsFullWithAfterQuery", "69c9ebfa3dc05e58e4bc1e412b290550", "viewer", "10154444360816729", RegularImmutableSet.a);
    }

    public final String m11761a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "4";
            case -1439844555:
                return "5";
            case -713514397:
                return "0";
            case 92734940:
                return "1";
            case 102976443:
                return "2";
            case 693548892:
                return "3";
            default:
                return str;
        }
    }
}
