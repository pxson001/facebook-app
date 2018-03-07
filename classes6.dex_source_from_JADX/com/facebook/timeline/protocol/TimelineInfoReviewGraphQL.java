package com.facebook.timeline.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.TimelineInfoReviewQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: days */
public final class TimelineInfoReviewGraphQL {

    /* compiled from: days */
    public class TimelineInfoReviewQueryString extends TypedGraphQlQueryString<TimelineInfoReviewQueryModel> {
        public TimelineInfoReviewQueryString() {
            super(TimelineInfoReviewQueryModel.class, false, "TimelineInfoReviewQuery", "020915c26130b5c940d6e5c7639a60b7", "viewer", "10154429040261729", RegularImmutableSet.a);
        }

        public final TriState m26333g() {
            return TriState.NO;
        }

        public final String m26332a(String str) {
            switch (str.hashCode()) {
                case -1853231955:
                    return "3";
                case 112787:
                    return "2";
                case 109250890:
                    return "1";
                case 1984987798:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
