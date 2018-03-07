package com.facebook.video.videohome.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.video.videohome.protocol.VideoHomeMutationsModels.VideoHomeVisitMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: disclaimer_responses */
public final class VideoHomeMutations {

    /* compiled from: disclaimer_responses */
    public class VideoHomeVisitMutationString extends TypedGraphQLMutationString<VideoHomeVisitMutationModel> {
        public VideoHomeVisitMutationString() {
            super(VideoHomeVisitMutationModel.class, false, "VideoHomeVisitMutation", "90678cbdadd3c4e1557a7b808f941dd3", "video_home_visit", "0", "10154393038856729", RegularImmutableSet.a);
        }

        public final String m19675a(String str) {
            switch (str.hashCode()) {
                case 1018164666:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
