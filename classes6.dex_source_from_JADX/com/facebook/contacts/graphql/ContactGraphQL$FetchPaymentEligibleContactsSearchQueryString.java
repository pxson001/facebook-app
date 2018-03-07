package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.FetchPaymentEligibleContactsSearchQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchPaymentEligibleContactsSearchQueryString extends TypedGraphQlQueryString<FetchPaymentEligibleContactsSearchQueryModel> {
    public ContactGraphQL$FetchPaymentEligibleContactsSearchQueryString() {
        super(FetchPaymentEligibleContactsSearchQueryModel.class, false, "FetchPaymentEligibleContactsSearchQuery", "72c9974142f6dccaaa41c55af4e43726", "viewer", "10154444360766729", RegularImmutableSet.a);
    }

    public final String m11763a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "3";
            case -1439844555:
                return "4";
            case 102976443:
                return "1";
            case 693548892:
                return "2";
            case 1847487700:
                return "0";
            default:
                return str;
        }
    }
}
