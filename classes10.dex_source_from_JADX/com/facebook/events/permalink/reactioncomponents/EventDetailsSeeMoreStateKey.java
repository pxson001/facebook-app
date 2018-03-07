package com.facebook.events.permalink.reactioncomponents;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.sections.text.ExpandingContentTextPersistentState;

/* compiled from: background_location_traveling_nux_actor_info_fetch_fail */
public class EventDetailsSeeMoreStateKey implements ContextStateKey<String, ExpandingContentTextPersistentState> {
    private static final String f18802a = EventDetailsSeeMoreStateKey.class.getSimpleName();
    private final String f18803b;

    public EventDetailsSeeMoreStateKey(String str) {
        this.f18803b = f18802a + str;
    }

    public final Object m19104a() {
        return new ExpandingContentTextPersistentState();
    }

    public final Object m19105b() {
        return this.f18803b;
    }
}
