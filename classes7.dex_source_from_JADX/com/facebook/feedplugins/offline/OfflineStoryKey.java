package com.facebook.feedplugins.offline;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: STICKER_KEYBOARD_SELECT */
public class OfflineStoryKey implements ContextStateKey<String, OfflineStoryPersistentState> {
    private final String f23556a;

    public OfflineStoryKey(GraphQLStory graphQLStory) {
        this.f23556a = graphQLStory.V();
    }

    public final Object m25799b() {
        return this.f23556a;
    }

    public final Object m25798a() {
        return new OfflineStoryPersistentState();
    }
}
