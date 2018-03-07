package com.facebook.search.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQLModels.FBTypeaheadPYMKQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: network error */
public final class FetchTypeaheadPYMKGraphQL {

    /* compiled from: network error */
    public class FBTypeaheadPYMKQueryString extends TypedGraphQlQueryString<FBTypeaheadPYMKQueryModel> {
        public FBTypeaheadPYMKQueryString() {
            super(FBTypeaheadPYMKQueryModel.class, false, "FBTypeaheadPYMKQuery", "0fc910b9605996bbfa6db0e1989ad3e6", "viewer", "10154429040001729", RegularImmutableSet.a);
        }

        public final boolean m8913l() {
            return true;
        }

        public final int[][] m8914m() {
            return new int[][]{new int[]{0, 0, Integer.MIN_VALUE, 0}};
        }

        public final String m8912a(String str) {
            switch (str.hashCode()) {
                case 94851343:
                    return "0";
                case 692733304:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
