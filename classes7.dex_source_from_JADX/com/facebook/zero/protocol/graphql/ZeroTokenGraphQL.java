package com.facebook.zero.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.FetchZeroTokenQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: xhrEncoding */
public final class ZeroTokenGraphQL {

    /* compiled from: xhrEncoding */
    public class FetchZeroTokenQueryString extends TypedGraphQlQueryString<FetchZeroTokenQueryModel> {
        public FetchZeroTokenQueryString() {
            super(FetchZeroTokenQueryModel.class, false, "FetchZeroTokenQuery", "5f42cc48737f37f150b8e2e0be75acc9", "viewer", "10154597590936729", RegularImmutableSet.a);
        }

        public final String m165a(String str) {
            switch (str.hashCode()) {
                case -618697500:
                    return "0";
                case 3195150:
                    return "2";
                case 1881018012:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
