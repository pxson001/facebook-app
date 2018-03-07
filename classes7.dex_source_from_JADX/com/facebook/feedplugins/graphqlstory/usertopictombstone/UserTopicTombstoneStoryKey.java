package com.facebook.feedplugins.graphqlstory.usertopictombstone;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;

/* compiled from: SWIPING_IMAGE */
public class UserTopicTombstoneStoryKey implements ContextStateKey<String, UserTopicTombstonePersistentState> {
    private static final String f23489a = UserTopicTombstoneStoryKey.class.getName();
    private final String f23490b;

    public UserTopicTombstoneStoryKey(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit) {
        this.f23490b = f23489a + negativeFeedbackActionsUnit.g();
    }

    public final Object m25756a() {
        return new UserTopicTombstonePersistentState();
    }

    public final Object m25757b() {
        return this.f23490b;
    }
}
