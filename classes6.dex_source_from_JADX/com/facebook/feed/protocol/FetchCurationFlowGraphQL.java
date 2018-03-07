package com.facebook.feed.protocol;

import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: movie_poster_image */
public final class FetchCurationFlowGraphQL {

    /* compiled from: movie_poster_image */
    public class FetchCurationFlowString extends TypedGraphQlQueryString<FetchCurationFlowModel> {
        public FetchCurationFlowString() {
            super(FetchCurationFlowModel.class, false, "FetchCurationFlow", "d6ab75e8fccb9bb74728186f290dc2a7", "node", "10154405017751729", RegularImmutableSet.a);
        }

        public final String m15873a(String str) {
            switch (str.hashCode()) {
                case -1422950858:
                    return "1";
                case 1583616142:
                    return "2";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
