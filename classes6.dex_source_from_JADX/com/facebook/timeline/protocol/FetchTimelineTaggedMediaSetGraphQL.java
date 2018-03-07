package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLModels.TimelineTaggedMediaSetQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: default_currency */
public final class FetchTimelineTaggedMediaSetGraphQL {

    /* compiled from: default_currency */
    public class TimelineTaggedMediaSetQueryString extends TypedGraphQlQueryString<TimelineTaggedMediaSetQueryModel> {
        public TimelineTaggedMediaSetQueryString() {
            super(TimelineTaggedMediaSetQueryModel.class, false, "TimelineTaggedMediaSetQuery", "ced3196f85575b9ce96eeaec6a451f87", "user", "10154405445861729", RegularImmutableSet.a);
        }

        public final String m26189a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
