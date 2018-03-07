package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: aspectRatio */
public class ReactionTabSwitcherKey implements ContextStateKey<String, ReactionTabSwitcherPersistentState> {
    private static final String f19181a = ReactionTabSwitcherKey.class.getSimpleName();
    private String f19182b;

    public ReactionTabSwitcherKey(String str) {
        this.f19182b = f19181a + str;
    }

    public final Object m23196a() {
        return new ReactionTabSwitcherPersistentState();
    }

    public final Object m23197b() {
        return this.f19182b;
    }
}
