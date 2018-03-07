package com.facebook.timeline.refresher.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineNuxQueryModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineRefresherQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: unmuteMicrophone */
public final class FetchProfileRefresherGraphQL {

    /* compiled from: unmuteMicrophone */
    public class TimelineCoverPhotoUriQueryString extends TypedGraphQlQueryString<TimelineCoverPhotoUriQueryModel> {
        public TimelineCoverPhotoUriQueryString() {
            super(TimelineCoverPhotoUriQueryModel.class, false, "TimelineCoverPhotoUriQuery", "d905824ca4ae1ee9b3277236404b2685", "user", "10154405445841729", RegularImmutableSet.a);
        }

        public final String m1068a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                case -147799178:
                    return "1";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: unmuteMicrophone */
    public class TimelineNuxQueryString extends TypedGraphQlQueryString<TimelineNuxQueryModel> {
        public TimelineNuxQueryString() {
            super(TimelineNuxQueryModel.class, false, "TimelineNuxQuery", "0b28e7635078b706ec28775c0b77189a", "viewer", "10154343228641729", RegularImmutableSet.a);
        }

        public final String m1069a(String str) {
            switch (str.hashCode()) {
                case 1992371210:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: unmuteMicrophone */
    public class TimelineRefresherQueryString extends TypedGraphQlQueryString<TimelineRefresherQueryModel> {
        public TimelineRefresherQueryString() {
            super(TimelineRefresherQueryModel.class, false, "TimelineRefresherQuery", "a7f79724fd013ca9032de6d3f2f1adcd", "viewer", "10154343228636729", RegularImmutableSet.a);
        }

        public final String m1070a(String str) {
            switch (str.hashCode()) {
                case -430534157:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final TimelineCoverPhotoUriQueryString m1071c() {
        return new TimelineCoverPhotoUriQueryString();
    }
}
