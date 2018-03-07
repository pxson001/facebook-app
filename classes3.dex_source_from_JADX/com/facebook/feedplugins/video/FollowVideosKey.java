package com.facebook.feedplugins.video;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.Nullable;

/* compiled from: _SPHERICAL_PHOTOS */
public class FollowVideosKey implements ContextStateKey<String, FollowVideosState> {
    private final String f273a;

    public FollowVideosKey(@Nullable GraphQLStory graphQLStory) {
        this.f273a = FollowVideosKey.class.toString() + (graphQLStory != null ? graphQLStory.g() : "0");
    }

    public final Object m253a() {
        return new FollowVideosState();
    }

    public final Object m254b() {
        return this.f273a;
    }
}
