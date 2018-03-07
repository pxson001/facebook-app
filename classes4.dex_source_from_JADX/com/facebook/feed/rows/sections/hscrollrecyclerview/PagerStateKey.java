package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: device_api */
public class PagerStateKey implements ContextStateKey<String, PagerPersistentState> {
    private final String f13929a;

    private PagerStateKey(String str) {
        this.f13929a = getClass() + str;
    }

    public static PagerStateKey m14738a(String str) {
        return new PagerStateKey(str);
    }

    public final Object m14740b() {
        return this.f13929a;
    }

    public final Object m14739a() {
        return new PagerPersistentState();
    }
}
