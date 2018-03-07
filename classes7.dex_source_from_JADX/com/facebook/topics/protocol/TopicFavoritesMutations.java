package com.facebook.topics.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.topics.protocol.TopicFavoritesMutationsModels.SetOfFavoritesMutationFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesMutationsModels.VideoChannelSetPinStateMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_selected_meme */
public final class TopicFavoritesMutations {

    /* compiled from: extra_selected_meme */
    public class FavoriteASetOfTopicFeedsMutationString extends TypedGraphQLMutationString<SetOfFavoritesMutationFragmentModel> {
        public FavoriteASetOfTopicFeedsMutationString() {
            super(SetOfFavoritesMutationFragmentModel.class, false, "FavoriteASetOfTopicFeedsMutation", "6dacde77d4eb139d48fb0938dd7ce252", "topics_set_favorites", "0", "10154342150906729", RegularImmutableSet.a);
        }

        public final String m18859a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_selected_meme */
    public class VideoChannelSetPinStateMutationString extends TypedGraphQLMutationString<VideoChannelSetPinStateMutationModel> {
        public VideoChannelSetPinStateMutationString() {
            super(VideoChannelSetPinStateMutationModel.class, false, "VideoChannelSetPinStateMutation", "2b4fc43f28cbd73e79ac45700ca2d245", "video_channel_set_pin_state", "0", "10154446955421729", RegularImmutableSet.a);
        }

        public final String m18860a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
