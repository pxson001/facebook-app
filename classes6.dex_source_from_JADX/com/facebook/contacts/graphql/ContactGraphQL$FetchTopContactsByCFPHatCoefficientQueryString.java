package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.FetchTopContactsByCFPHatCoefficientQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$FetchTopContactsByCFPHatCoefficientQueryString extends TypedGraphQlQueryString<FetchTopContactsByCFPHatCoefficientQueryModel> {
    public ContactGraphQL$FetchTopContactsByCFPHatCoefficientQueryString() {
        super(FetchTopContactsByCFPHatCoefficientQueryModel.class, false, "FetchTopContactsByCFPHatCoefficientQuery", "28c0acd7962e798fc3d9988b876f4cfe", "viewer", "10154631644786729", RegularImmutableSet.a);
    }

    public final String m11764a(String str) {
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
