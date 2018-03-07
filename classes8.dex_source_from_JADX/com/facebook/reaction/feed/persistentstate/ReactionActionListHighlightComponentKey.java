package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: author_id */
public class ReactionActionListHighlightComponentKey implements ContextStateKey<String, ReactionActionListHighlightPersistentState> {
    private static final String f19152a = ReactionActionListHighlightComponentKey.class.getSimpleName();
    private final String f19153b;

    public ReactionActionListHighlightComponentKey(String str) {
        this.f19153b = f19152a + str;
    }

    public final Object m23175a() {
        return new ReactionActionListHighlightPersistentState();
    }

    public final Object m23176b() {
        return this.f19153b;
    }
}
