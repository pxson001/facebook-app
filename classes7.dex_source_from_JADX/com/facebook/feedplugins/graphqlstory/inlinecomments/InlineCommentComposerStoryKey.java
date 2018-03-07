package com.facebook.feedplugins.graphqlstory.inlinecomments;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Service not found */
public class InlineCommentComposerStoryKey implements ContextStateKey<String, InlineCommentPersistentState> {
    private static final String f23341a = InlineCommentComposerStoryKey.class.getName();
    private final String f23342b;

    public InlineCommentComposerStoryKey(GraphQLStory graphQLStory) {
        this.f23342b = f23341a + graphQLStory.g();
    }

    public final Object m25688b() {
        return this.f23342b;
    }

    public final Object m25687a() {
        return new InlineCommentPersistentState();
    }
}
