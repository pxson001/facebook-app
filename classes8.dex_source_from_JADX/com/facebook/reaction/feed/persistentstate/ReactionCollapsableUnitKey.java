package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: audio_title */
public class ReactionCollapsableUnitKey implements ContextStateKey<String, ReactionCollapsableUnitPersistentState> {
    private static final String f19158a = ReactionCollapsableUnitKey.class.getSimpleName();
    private final String f19159b;

    public ReactionCollapsableUnitKey(String str) {
        this.f19159b = f19158a + str;
    }

    public final Object m23180a() {
        return new ReactionCollapsableUnitPersistentState();
    }

    public final Object m23181b() {
        return this.f19159b;
    }
}
