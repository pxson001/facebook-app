package com.facebook.pages.common.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: setRating */
public final class FetchPageActivityGraphQL {

    /* compiled from: setRating */
    public class FetchPageActivityQueryString extends TypedGraphQlQueryString<FetchPageActivityQueryModel> {
        public FetchPageActivityQueryString() {
            super(FetchPageActivityQueryModel.class, false, "FetchPageActivityQuery", "338589fd4ccd947ff68a9fd9ba25ae19", "node", "10154686281601729", RegularImmutableSet.a);
        }

        public final String m2687a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FetchPageActivityQueryString m2688a() {
        return new FetchPageActivityQueryString();
    }
}
