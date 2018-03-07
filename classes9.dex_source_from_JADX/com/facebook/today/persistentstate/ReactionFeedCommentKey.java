package com.facebook.today.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: type_source_map */
public class ReactionFeedCommentKey implements ContextStateKey<String, ReactionFeedCommentPersistentState> {
    private static final String f1225a = ReactionFeedCommentKey.class.getSimpleName();
    private final String f1226b;

    public ReactionFeedCommentKey(String str) {
        this.f1226b = f1225a + str;
    }

    public final Object m1385a() {
        return new ReactionFeedCommentPersistentState();
    }

    public final Object m1386b() {
        return this.f1226b;
    }
}
