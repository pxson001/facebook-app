package com.facebook.zero.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.zero.protocol.graphql.ZeroOptinGraphQLModels.FetchZeroOptinQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: yyyyMMdd_HHmmss */
public final class ZeroOptinGraphQL {

    /* compiled from: yyyyMMdd_HHmmss */
    public class FetchZeroOptinQueryString extends TypedGraphQlQueryString<FetchZeroOptinQueryModel> {
        public FetchZeroOptinQueryString() {
            super(FetchZeroOptinQueryModel.class, false, "FetchZeroOptinQuery", "3f202d5a86ce363dc6748f416343ff15", "viewer", "10154491930436729", RegularImmutableSet.a);
        }

        public final String m127a(String str) {
            switch (str.hashCode()) {
                case -1336529993:
                    return "0";
                case -767592506:
                    return "1";
                case -767592165:
                    return "2";
                case 502623545:
                    return "5";
                case 2093370917:
                    return "3";
                case 2093371258:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
