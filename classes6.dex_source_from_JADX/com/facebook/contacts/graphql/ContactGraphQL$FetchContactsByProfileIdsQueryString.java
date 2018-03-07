package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsByProfileIdsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchContactsByProfileIdsQueryString extends TypedGraphQlQueryString<Map<String, FetchContactsByProfileIdsQueryModel>> {
    public ContactGraphQL$FetchContactsByProfileIdsQueryString() {
        super(FetchContactsByProfileIdsQueryModel.class, true, "FetchContactsByProfileIdsQuery", "75a3245832ef1c0d9f9a1d4ca771d0b8", "nodes", "10154444360796729", RegularImmutableSet.a);
    }

    public final String m11759a(String str) {
        switch (str.hashCode()) {
            case -1906025967:
                return "2";
            case -1439844555:
                return "3";
            case 178017058:
                return "0";
            case 693548892:
                return "1";
            default:
                return str;
        }
    }
}
