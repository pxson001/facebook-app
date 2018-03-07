package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: attachment_target_id */
public class ReactionHScrollComponentKey implements ContextStateKey<String, ReactionHScrollComponentPersistentState> {
    private static final String f19169a = ReactionHScrollComponentKey.class.getSimpleName();
    private String f19170b;

    public ReactionHScrollComponentKey(String str) {
        this.f19170b = f19169a + str;
    }

    public final Object m23188a() {
        return new ReactionHScrollComponentPersistentState();
    }

    public final Object m23189b() {
        return this.f19170b;
    }
}
