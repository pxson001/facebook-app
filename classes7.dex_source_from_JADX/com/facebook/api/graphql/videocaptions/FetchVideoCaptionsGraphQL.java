package com.facebook.api.graphql.videocaptions;

import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQLModels.FetchVideoCaptionsGraphQLModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_edit_data */
public final class FetchVideoCaptionsGraphQL {

    /* compiled from: video_edit_data */
    public class FetchVideoCaptionsGraphQLString extends TypedGraphQlQueryString<FetchVideoCaptionsGraphQLModel> {
        public FetchVideoCaptionsGraphQLString() {
            super(FetchVideoCaptionsGraphQLModel.class, false, "FetchVideoCaptionsGraphQL", "02586b00d5ae7bc5271e2eeb119d8f28", "video", "10154405445066729", RegularImmutableSet.a);
        }

        public final String m676a(String str) {
            switch (str.hashCode()) {
                case 338410841:
                    return "1";
                case 1151387487:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
