package com.facebook.video.videohome.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomeBadgeQueryModel;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataNoBadgingQueryModel;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: diode_divebar */
public final class VideoHomeQuery {

    /* compiled from: diode_divebar */
    public class VideoHomeBadgeQueryString extends TypedGraphQlQueryString<VideoHomeBadgeQueryModel> {
        public VideoHomeBadgeQueryString() {
            super(VideoHomeBadgeQueryModel.class, false, "VideoHomeBadgeQuery", "d6b6cc82c59ace6e59d46d77d56d6ac8", "viewer", "10154433521771729", RegularImmutableSet.a);
        }
    }

    /* compiled from: diode_divebar */
    public class VideoHomePrefetchMetadataNoBadgingQueryString extends TypedGraphQlQueryString<VideoHomePrefetchMetadataNoBadgingQueryModel> {
        public VideoHomePrefetchMetadataNoBadgingQueryString() {
            super(VideoHomePrefetchMetadataNoBadgingQueryModel.class, false, "VideoHomePrefetchMetadataNoBadgingQuery", "d895b1aad4ce698fa481ae42663fa708", "viewer", "10154679257811729", RegularImmutableSet.a);
        }
    }

    /* compiled from: diode_divebar */
    public class VideoHomePrefetchMetadataQueryString extends TypedGraphQlQueryString<VideoHomePrefetchMetadataQueryModel> {
        public VideoHomePrefetchMetadataQueryString() {
            super(VideoHomePrefetchMetadataQueryModel.class, false, "VideoHomePrefetchMetadataQuery", "0c5aeb81b4a6d81dd3d7cd3ff52fab0e", "viewer", "10154448851371729", RegularImmutableSet.a);
        }
    }
}
