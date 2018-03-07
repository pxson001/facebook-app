package com.facebook.feed.rows.sections.text;

import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: UNINITIALIZED */
public class ExpandingContentTextKey implements ContextStateKey<String, ExpandingContentTextPersistentState> {
    private final String f21571a;

    public ExpandingContentTextKey(GraphQLStory graphQLStory) {
        this.f21571a = getClass() + StoryKeyUtil.a(graphQLStory);
    }

    public final Object m24201a() {
        return new ExpandingContentTextPersistentState();
    }

    public final Object m24202b() {
        return this.f21571a;
    }
}
