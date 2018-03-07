package com.facebook.feed.util;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feedcache.memory.FeedSegment;
import com.facebook.common.errorreporting.memory.ClassInstancesToLog;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: trust/afro/?reportable_ent_token=%s&initial_action=%s&story_location=%s */
public class FeedClassInstancesToLog implements ClassInstancesToLog {
    public final Set<Class> mo636a() {
        return Sets.m1315a(GraphQLStory.class, GraphQLFeedback.class, FeedUnitCollection.class, FeedSegment.class);
    }
}
