package com.facebook.topics.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.topics.protocol.TopicClassificationQueryModels.TopicClassificationQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: eye */
public final class TopicClassificationQuery {

    /* compiled from: eye */
    public class TopicClassificationQueryString extends TypedGraphQlQueryString<TopicClassificationQueryModel> {
        public TopicClassificationQueryString() {
            super(TopicClassificationQueryModel.class, false, "TopicClassificationQuery", "b83f80a42a46b9783d8a6e9b3b7265d2", "feed_topics_classification", "10154626449671729", RegularImmutableSet.a);
        }

        public final String m18831a(String str) {
            switch (str.hashCode()) {
                case 1491856605:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
