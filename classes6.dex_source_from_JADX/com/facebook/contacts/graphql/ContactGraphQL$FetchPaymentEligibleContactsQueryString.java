package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.FetchPaymentEligibleContactsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchPaymentEligibleContactsQueryString extends TypedGraphQlQueryString<FetchPaymentEligibleContactsQueryModel> {
    public ContactGraphQL$FetchPaymentEligibleContactsQueryString() {
        super(FetchPaymentEligibleContactsQueryModel.class, false, "FetchPaymentEligibleContactsQuery", "512d3a3a737820afa131d7a2f15a9b2b", "viewer", "10154444360771729", RegularImmutableSet.a);
    }

    public final String m11762a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "2";
            case -1439844555:
                return "3";
            case 102976443:
                return "0";
            case 693548892:
                return "1";
            default:
                return str;
        }
    }
}
