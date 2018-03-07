package com.facebook.feedplugins.topiccustomizationstory.protocols;

import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutationsModels.TopicFeedOptionDeselectMutationModel;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutationsModels.TopicFeedOptionSelectMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: android.os.StrictMode$ViolationInfo */
public final class TopicFeedOptionMutations {

    /* compiled from: android.os.StrictMode$ViolationInfo */
    public class TopicFeedOptionDeselectMutationString extends TypedGraphQLMutationString<TopicFeedOptionDeselectMutationModel> {
        public TopicFeedOptionDeselectMutationString() {
            super(TopicFeedOptionDeselectMutationModel.class, false, "TopicFeedOptionDeselectMutation", "23b117f717bd920cf8e73a9270a248a3", "topic_feed_option_deselect", "0", "10154580740861729", RegularImmutableSet.a);
        }

        public final String m10331a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                case 1598177384:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: android.os.StrictMode$ViolationInfo */
    public class TopicFeedOptionSelectMutationString extends TypedGraphQLMutationString<TopicFeedOptionSelectMutationModel> {
        public TopicFeedOptionSelectMutationString() {
            super(TopicFeedOptionSelectMutationModel.class, false, "TopicFeedOptionSelectMutation", "f83b8f451988308a64c914ba764fa6d1", "topic_feed_option_select", "0", "10154580740846729", RegularImmutableSet.a);
        }

        public final String m10332a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                case 1598177384:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
