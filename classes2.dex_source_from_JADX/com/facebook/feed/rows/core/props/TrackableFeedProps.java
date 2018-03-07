package com.facebook.feed.rows.core.props;

import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;

/* compiled from: instant_articles_in_saved_collection */
public class TrackableFeedProps {
    public static ArrayNode m27451a(FeedProps<? extends CachedFeedTrackable> feedProps) {
        CachedFeedTrackable cachedFeedTrackable = (CachedFeedTrackable) feedProps.f13444a;
        ArrayNode a = PropertyHelper.m21262a(cachedFeedTrackable);
        if (a != null) {
            return a;
        }
        CachedFeedTrackable cachedFeedTrackable2;
        if (cachedFeedTrackable instanceof GraphQLStoryAttachment) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
            cachedFeedTrackable2 = (GraphQLStoryAttachment) feedProps.f13444a;
            if (cachedFeedTrackable2.m23965B() != null) {
                arrayNode.m13394h(cachedFeedTrackable2.m23965B());
            }
            if (feedProps.m19807c() instanceof CachedFeedTrackable) {
                ArrayNode a2 = m27451a(feedProps.f13445b);
                if (a2 != null) {
                    arrayNode.m13382a(a2);
                }
            }
            PropertyHelper.m21281a(cachedFeedTrackable2, arrayNode);
            return arrayNode;
        } else if (!(cachedFeedTrackable instanceof GraphQLStory)) {
            return FeedTrackableUtil.m27151a(cachedFeedTrackable);
        } else {
            String k;
            ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.f3121a);
            cachedFeedTrackable2 = (GraphQLStory) feedProps.f13444a;
            if (cachedFeedTrackable2.mo2877k() != null) {
                arrayNode2.m13394h(cachedFeedTrackable2.mo2877k());
            }
            ImmutableList d = feedProps.m19808d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                Flattenable flattenable = (Flattenable) d.get(i);
                if (flattenable instanceof HasTracking) {
                    k = ((HasTracking) flattenable).mo2877k();
                    if (k != null) {
                        arrayNode2.m13394h(k);
                    }
                }
            }
            k = StoryProps.m27467r(feedProps);
            if (k != null) {
                arrayNode2.m13394h(k);
            }
            PropertyHelper.m21281a(cachedFeedTrackable2, arrayNode2);
            return arrayNode2;
        }
    }

    public static ArrayNode m27452b(FeedProps feedProps) {
        Object obj = feedProps.f13444a;
        if (obj instanceof CachedFeedTrackable) {
            return m27451a(feedProps);
        }
        return FeedTrackableUtil.m27153a(obj);
    }
}
