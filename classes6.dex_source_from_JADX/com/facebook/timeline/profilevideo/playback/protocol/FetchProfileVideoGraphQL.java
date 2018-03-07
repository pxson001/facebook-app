package com.facebook.timeline.profilevideo.playback.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: deltaFolderCount */
public final class FetchProfileVideoGraphQL {

    /* compiled from: deltaFolderCount */
    public class ProfileVideoDetailQueryString extends TypedGraphQlQueryString<VideoDetailFragmentModel> {
        public ProfileVideoDetailQueryString() {
            super(VideoDetailFragmentModel.class, false, "ProfileVideoDetailQuery", "123d2a45e467a60cee9c2c2fbd30c77d", "video", "10154561741376729", RegularImmutableSet.a);
        }

        public final String m25636a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "2";
                case -631654088:
                    return "1";
                case -561505403:
                    return "6";
                case 421050507:
                    return "3";
                case 580042479:
                    return "5";
                case 651215103:
                    return "7";
                case 1151387487:
                    return "0";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
