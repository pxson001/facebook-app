package com.facebook.messaging.graphql.threads;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.graphql.threads.AppVisibilityQueriesModels.AttributionVisibilityModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_duration */
public final class AppVisibilityQueries {

    /* compiled from: video_duration */
    public class AttributionVisibilityString extends TypedGraphQlQueryString<AttributionVisibilityModel> {
        public AttributionVisibilityString() {
            super(AttributionVisibilityModel.class, false, "AttributionVisibility", "0dc56d6e0781f9118e51f89fc9a9b461", "node", "10154341706471729", RegularImmutableSet.a);
        }

        public final String m815a(String str) {
            switch (str.hashCode()) {
                case -1422950858:
                    return "1";
                case 93029116:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
