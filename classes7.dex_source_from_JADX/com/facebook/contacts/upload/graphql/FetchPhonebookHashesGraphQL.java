package com.facebook.contacts.upload.graphql;

import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLModels.FetchPhonebookHashesQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tapped_all_nearby_locations_list */
public final class FetchPhonebookHashesGraphQL {

    /* compiled from: tapped_all_nearby_locations_list */
    public class FetchPhonebookHashesQueryString extends TypedGraphQlQueryString<FetchPhonebookHashesQueryModel> {
        public FetchPhonebookHashesQueryString() {
            super(FetchPhonebookHashesQueryModel.class, false, "FetchPhonebookHashesQuery", "f0db4b849ed69da5f502919c5aba215a", "viewer", "10154233766711729", RegularImmutableSet.a);
        }

        public final String m2138a(String str) {
            switch (str.hashCode()) {
                case -174052094:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
