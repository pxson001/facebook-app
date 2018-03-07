package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.protocol.TimelineCommonGraphQLModels.TimelinePhotoUriQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: db_bootstrap_keywords_last_fetch_ms */
public final class TimelineCommonGraphQL {

    /* compiled from: db_bootstrap_keywords_last_fetch_ms */
    public class TimelinePhotoUriQueryString extends TypedGraphQlQueryString<TimelinePhotoUriQueryModel> {
        public TimelinePhotoUriQueryString() {
            super(TimelinePhotoUriQueryModel.class, false, "TimelinePhotoUriQuery", "86c3a7f44e15f43269cce5cc15704393", "node", "10154358539501729", RegularImmutableSet.a);
        }

        public final String m26321a(String str) {
            switch (str.hashCode()) {
                case -508010268:
                    return "0";
                case 1447485817:
                    return "1";
                case 1489392596:
                    return "2";
                default:
                    return str;
            }
        }
    }

    public static final TimelinePhotoUriQueryString m26322a() {
        return new TimelinePhotoUriQueryString();
    }
}
