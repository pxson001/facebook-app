package com.facebook.topics.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.topics.protocol.UserTopicMutationsModels.TopicHideUserMutationResponseFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_meme_picker_composer_config */
public final class UserTopicMutations {

    /* compiled from: extra_meme_picker_composer_config */
    public class TopicHideUserMutationString extends TypedGraphQLMutationString<TopicHideUserMutationResponseFragmentModel> {
        public TopicHideUserMutationString() {
            super(TopicHideUserMutationResponseFragmentModel.class, false, "TopicHideUserMutation", "6046065d3aab96e8b58ea6af11fbf4be", "topic_hide_user", "0", "10154500798841729", RegularImmutableSet.a);
        }

        public final String m19030a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
