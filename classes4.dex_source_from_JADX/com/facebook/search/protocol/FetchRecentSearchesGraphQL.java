package com.facebook.search.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fromPaymentTrigger */
public final class FetchRecentSearchesGraphQL {

    /* compiled from: fromPaymentTrigger */
    public class FBRecentSearchesQueryString extends TypedGraphQlQueryString<FBRecentSearchesQueryModel> {
        public FBRecentSearchesQueryString() {
            super(FBRecentSearchesQueryModel.class, false, "FBRecentSearchesQuery", "f012e26db282d0a39b9554328af3365e", "viewer", "10154429039971729", RegularImmutableSet.a);
        }

        public final String m11795a(String str) {
            switch (str.hashCode()) {
                case -1274492040:
                    return "0";
                case -304567423:
                    return "4";
                case -151834201:
                    return "2";
                case 94851343:
                    return "1";
                case 692733304:
                    return "3";
                default:
                    return str;
            }
        }
    }

    public static final FBRecentSearchesQueryString m11801a() {
        return new FBRecentSearchesQueryString();
    }
}
