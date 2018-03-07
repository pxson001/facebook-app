package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: auth/openidconnect_email_confirmation */
public class ReactionActivatableActionPlaceKey implements ContextStateKey<String, ReactionActivatableActionPersistentState> {
    private static final String f19156a = ReactionActivatableActionPlaceKey.class.getSimpleName();
    private final String f19157b;

    public ReactionActivatableActionPlaceKey(String str) {
        this.f19157b = f19156a + str;
    }

    public final Object m23178a() {
        return new ReactionActivatableActionPersistentState();
    }

    public final Object m23179b() {
        return this.f19157b;
    }
}
