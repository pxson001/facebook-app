package com.facebook.feed.rows.core.events;

/* compiled from: We currently do not support multiple collectors inflight */
public class GoToNextPageHScrollEvent implements KeyedEvent<String> {
    private final String f12254a;

    public GoToNextPageHScrollEvent(String str) {
        this.f12254a = str;
    }

    public final Object m20280c() {
        return this.f12254a;
    }
}
