package com.facebook.feedplugins.pymi.rows;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: clipping */
public class FutureFriendingPagePartDefinition$FutureFriendingStateKey implements ContextStateKey<String, Boolean> {
    private final String f8759a;
    private final boolean f8760b;

    public FutureFriendingPagePartDefinition$FutureFriendingStateKey(String str, boolean z) {
        this.f8759a = FutureFriendingPagePartDefinition$FutureFriendingStateKey.class.getSimpleName() + str;
        this.f8760b = z;
    }

    public final Object m9544a() {
        return Boolean.valueOf(this.f8760b);
    }

    public final Object m9545b() {
        return this.f8759a;
    }
}
