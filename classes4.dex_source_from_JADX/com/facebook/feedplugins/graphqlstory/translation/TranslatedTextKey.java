package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: double-enqueue */
public class TranslatedTextKey implements ContextStateKey<String, TranslatedTextPersistentState> {
    private static final String f13709a = TranslatedTextKey.class.getName();
    private final String f13710b;

    public TranslatedTextKey(GraphQLStory graphQLStory) {
        this.f13710b = graphQLStory.c() + f13709a;
    }

    public final Object m14465a() {
        return new TranslatedTextPersistentState();
    }

    public final Object m14466b() {
        return this.f13710b;
    }
}
