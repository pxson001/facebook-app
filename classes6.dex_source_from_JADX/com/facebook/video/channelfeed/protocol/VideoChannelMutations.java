package com.facebook.video.channelfeed.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelFollowCoreMutationModel;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelSubscribeCoreMutationModel;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelUnfollowCoreMutationModel;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelUnsubscribeCoreMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contactlogs/ */
public final class VideoChannelMutations {

    /* compiled from: contactlogs/ */
    public class VideoChannelFollowCoreMutationString extends TypedGraphQLMutationString<VideoChannelFollowCoreMutationModel> {
        public VideoChannelFollowCoreMutationString() {
            super(VideoChannelFollowCoreMutationModel.class, false, "VideoChannelFollowCoreMutation", "447134d0bbf6bc1e4ad4eeec01fafadd", "video_channel_follow", "0", "10154513884261729", RegularImmutableSet.a);
        }

        public final String m27295a(String str) {
            switch (str.hashCode()) {
                case 935008376:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: contactlogs/ */
    public class VideoChannelSubscribeCoreMutationString extends TypedGraphQLMutationString<VideoChannelSubscribeCoreMutationModel> {
        public VideoChannelSubscribeCoreMutationString() {
            super(VideoChannelSubscribeCoreMutationModel.class, false, "VideoChannelSubscribeCoreMutation", "8490b5f412a90e08a32f4b0ebb2def48", "video_channel_subscribe", "0", "10154504468461729", RegularImmutableSet.a);
        }

        public final String m27296a(String str) {
            switch (str.hashCode()) {
                case -1676647297:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: contactlogs/ */
    public class VideoChannelUnfollowCoreMutationString extends TypedGraphQLMutationString<VideoChannelUnfollowCoreMutationModel> {
        public VideoChannelUnfollowCoreMutationString() {
            super(VideoChannelUnfollowCoreMutationModel.class, false, "VideoChannelUnfollowCoreMutation", "2627dd440f50ee7a1eb24b06802e162e", "video_channel_unfollow", "0", "10154513884266729", RegularImmutableSet.a);
        }

        public final String m27297a(String str) {
            switch (str.hashCode()) {
                case -1039867841:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: contactlogs/ */
    public class VideoChannelUnsubscribeCoreMutationString extends TypedGraphQLMutationString<VideoChannelUnsubscribeCoreMutationModel> {
        public VideoChannelUnsubscribeCoreMutationString() {
            super(VideoChannelUnsubscribeCoreMutationModel.class, false, "VideoChannelUnsubscribeCoreMutation", "d5b45d145ec253d150d059afdd637c45", "video_channel_unsubscribe", "0", "10154504468471729", RegularImmutableSet.a);
        }

        public final String m27298a(String str) {
            switch (str.hashCode()) {
                case 1542959960:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
