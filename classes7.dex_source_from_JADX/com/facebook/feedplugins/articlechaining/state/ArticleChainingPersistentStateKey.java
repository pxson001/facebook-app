package com.facebook.feedplugins.articlechaining.state;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: TOP_LEVEL */
public class ArticleChainingPersistentStateKey implements ContextStateKey<String, ArticleChainingPersistentState> {
    private final String f22540a;

    public ArticleChainingPersistentStateKey(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f22540a = getClass().toString() + graphQLStoryAttachment.C();
    }

    public final Object m25252a() {
        return new ArticleChainingPersistentState();
    }

    public final Object m25253b() {
        return this.f22540a;
    }
}
