package com.facebook.feedplugins.graphqlstory.followup;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: header */
public class FollowUpPersistentStateKey implements ContextStateKey<String, FollowUpPersistentState> {
    private final String f21185a;

    public FollowUpPersistentStateKey(GraphQLStory graphQLStory) {
        this.f21185a = getClass().toString() + (graphQLStory.mo2507g() != null ? graphQLStory.mo2507g() : Long.valueOf(graphQLStory.m22336V()));
    }

    public final Object mo2130a() {
        return new FollowUpPersistentState();
    }

    public final Object mo2131b() {
        return this.f21185a;
    }
}
