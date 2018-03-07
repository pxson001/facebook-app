package com.facebook.pages.common.reaction.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: seen_marketplace_cross_post_intercept */
public class PageActivityBadgeKey implements ContextStateKey<String, PageActivityBadgePersistentState> {
    private static final String f2129a = PageActivityBadgeKey.class.getSimpleName();
    private String f2130b;

    public PageActivityBadgeKey(String str, String str2) {
        this.f2130b = f2129a + str + str2;
    }

    public final Object m3154a() {
        return new PageActivityBadgePersistentState();
    }

    public final Object m3155b() {
        return this.f2130b;
    }
}
