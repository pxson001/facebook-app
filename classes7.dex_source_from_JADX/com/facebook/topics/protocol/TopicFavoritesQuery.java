package com.facebook.topics.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicListModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_platform_id */
public final class TopicFavoritesQuery {

    /* compiled from: extra_platform_id */
    public class TopicFeedListString extends TypedGraphQlQueryString<TopicFeedListModel> {
        public TopicFeedListString() {
            super(TopicFeedListModel.class, false, "TopicFeedList", "84136b3943ead6bf19c2ee5b15019468", "feed_topic_list", "10154573280596729", RegularImmutableSet.a);
        }

        public final String m18919a(String str) {
            switch (str.hashCode()) {
                case -1876287479:
                    return "0";
                case 109250890:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_platform_id */
    public class VideoTopicListString extends TypedGraphQlQueryString<VideoTopicListModel> {
        public VideoTopicListString() {
            super(VideoTopicListModel.class, false, "VideoTopicList", "3da5bc8d222db71e230bcc04701d5a2f", "feed_topic_list", "10154491362001729", RegularImmutableSet.a);
        }
    }
}
