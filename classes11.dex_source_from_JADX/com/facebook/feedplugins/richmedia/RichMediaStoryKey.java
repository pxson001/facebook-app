package com.facebook.feedplugins.richmedia;

import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: buttonPositive */
public class RichMediaStoryKey implements ContextStateKey<String, RichMediaStoryPersistentState> {
    private final String f9210a;

    public RichMediaStoryKey(GraphQLStory graphQLStory) {
        this.f9210a = getClass() + StoryKeyUtil.a(graphQLStory);
    }

    public final Object m9867b() {
        return this.f9210a;
    }

    public final Object m9866a() {
        return new RichMediaStoryPersistentState();
    }
}
