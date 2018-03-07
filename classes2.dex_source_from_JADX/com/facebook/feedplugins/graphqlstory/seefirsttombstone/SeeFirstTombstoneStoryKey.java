package com.facebook.feedplugins.graphqlstory.seefirsttombstone;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: imp */
public class SeeFirstTombstoneStoryKey implements ContextStateKey<String, SeeFirstTombstonePersistentState> {
    private static final String f20358a = SeeFirstTombstoneStoryKey.class.getName();
    private final String f20359b;

    public SeeFirstTombstoneStoryKey(GraphQLStory graphQLStory) {
        this.f20359b = f20358a + graphQLStory.mo2507g();
    }

    public final Object mo2130a() {
        return new SeeFirstTombstonePersistentState();
    }

    public final Object mo2131b() {
        return this.f20359b;
    }
}
