package com.facebook.reviews.util.protocol.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.reviews.util.protocol.graphql.FetchSingleViewerReviewGraphQLModels.FetchSingleViewerReviewGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: profile_video_android_deep_link_flow_success */
public final class FetchSingleViewerReviewGraphQL {

    /* compiled from: profile_video_android_deep_link_flow_success */
    public class FetchSingleViewerReviewGraphQLString extends TypedGraphQlQueryString<FetchSingleViewerReviewGraphQLModel> {
        public FetchSingleViewerReviewGraphQLString() {
            super(FetchSingleViewerReviewGraphQLModel.class, false, "FetchSingleViewerReviewGraphQL", "1cec344bcd173ac631a15607544273a8", "page", "10154661259331729", RegularImmutableSet.a);
        }

        public final TriState m4963g() {
            return TriState.NO;
        }

        public final String m4962a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
