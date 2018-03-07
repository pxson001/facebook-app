package com.facebook.feedplugins.graphqlstory.footer;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: Song */
public class FeedDiscoveryBlingBarPartDefinition$FeedDiscoveryStateKey implements ContextStateKey<String, FeedDiscoveryBlingBarPartDefinition$FeedDiscoveryPersistentState> {
    private final String f23227a;

    public FeedDiscoveryBlingBarPartDefinition$FeedDiscoveryStateKey(String str) {
        this.f23227a = getClass() + str;
    }

    public final Object m25612b() {
        return this.f23227a;
    }

    public final Object m25611a() {
        return new FeedDiscoveryBlingBarPartDefinition$FeedDiscoveryPersistentState();
    }
}
