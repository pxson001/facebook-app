package com.facebook.saved.common.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.saved.common.graphql.FetchRecentSaveInfoGraphQLModels.FetchRecentSaveInfoGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fetch_address */
public final class FetchRecentSaveInfoGraphQL {

    /* compiled from: fetch_address */
    public class FetchRecentSaveInfoGraphQLString extends TypedGraphQlQueryString<FetchRecentSaveInfoGraphQLModel> {
        public FetchRecentSaveInfoGraphQLString() {
            super(FetchRecentSaveInfoGraphQLModel.class, false, "FetchRecentSaveInfoGraphQL", "190f2779f13f47662abd19797d83da76", "viewer", "10154616854826729", RegularImmutableSet.a);
        }

        public final String m18292a(String str) {
            switch (str.hashCode()) {
                case -168137647:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
