package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: attachments_loaded */
public class ReactionExpandableComponentKey implements ContextStateKey<String, ReactionExpandableComponentPersistentState> {
    private static final String f19165a = ReactionExpandableComponentKey.class.getSimpleName();
    private final String f19166b;

    public ReactionExpandableComponentKey(String str) {
        this.f19166b = f19165a + str;
    }

    public final Object m23186a() {
        return new ReactionExpandableComponentPersistentState();
    }

    public final Object m23187b() {
        return this.f19166b;
    }
}
