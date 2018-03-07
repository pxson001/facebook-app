package com.facebook.feed.protocol;

import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLModels.FetchVideoBroadcastPlayAndFeedbackCountQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: min >= 0 AND (max >= min OR max == NO_MAX) */
public final class FetchVideoBroadcastPlayAndFeedbackCountGraphQL {

    /* compiled from: min >= 0 AND (max >= min OR max == NO_MAX) */
    public class FetchVideoBroadcastPlayAndFeedbackCountQueryString extends TypedGraphQlQueryString<FetchVideoBroadcastPlayAndFeedbackCountQueryModel> {
        public FetchVideoBroadcastPlayAndFeedbackCountQueryString() {
            super(FetchVideoBroadcastPlayAndFeedbackCountQueryModel.class, false, "FetchVideoBroadcastPlayAndFeedbackCountQuery", "ec68282bfd56fa644d8f50af2d2455e2", "node", "10154341705776729", RegularImmutableSet.a);
        }

        public final String m16351a(String str) {
            switch (str.hashCode()) {
                case 1151387487:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
