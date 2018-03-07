package com.facebook.photos.upload.serverprocessing;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.upload.serverprocessing.VideoStatusQueryModels.VideoStatusQueryModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: full_interstitial_bubble */
public final class VideoStatusQuery {

    /* compiled from: full_interstitial_bubble */
    public class VideoStatusQueryString extends TypedGraphQlQueryString<Map<String, VideoStatusQueryModel>> {
        public VideoStatusQueryString() {
            super(VideoStatusQueryModel.class, true, "VideoStatusQuery", "c3a474277b7571d1c80d9d2f7aaabf6d", "videos", "10154321607676729", RegularImmutableSet.a);
        }

        public final String m21922a(String str) {
            switch (str.hashCode()) {
                case -815598713:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
