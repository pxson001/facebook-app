package com.facebook.reviews.util.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.reviews.util.protocol.graphql.FetchPageOverallRatingModels.FetchPageOverallRatingModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: profile_video_android_scrubber_closed */
public final class FetchPageOverallRating {

    /* compiled from: profile_video_android_scrubber_closed */
    public class FetchPageOverallRatingString extends TypedGraphQlQueryString<FetchPageOverallRatingModel> {
        public FetchPageOverallRatingString() {
            super(FetchPageOverallRatingModel.class, false, "FetchPageOverallRating", "e79f1b50440204b9d6dd54622c8f02f3", "page", "10154405445731729", RegularImmutableSet.a);
        }

        public final String m4952a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
