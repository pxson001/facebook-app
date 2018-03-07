package com.facebook.feed.rows.core.persistence;

/* compiled from: WWW_SEARCH_LOCAL_TODAY */
public class PageIndicatorCurrentPositionStateKey implements ContextStateKey<String, PageIndicatorCurrentPositionState> {
    private final String f12270a;

    public PageIndicatorCurrentPositionStateKey(String str) {
        this.f12270a = str;
    }

    public final Object m20298b() {
        return this.f12270a;
    }

    public final Object m20297a() {
        return new PageIndicatorCurrentPositionState();
    }
}
