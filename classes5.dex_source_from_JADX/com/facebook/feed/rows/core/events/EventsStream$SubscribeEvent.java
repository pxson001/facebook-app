package com.facebook.feed.rows.core.events;

import android.util.Pair;

/* compiled from: WeakPassword */
public class EventsStream$SubscribeEvent implements KeyedEvent<Pair> {
    public final Pair f12251a;
    public final Action f12252b;

    public EventsStream$SubscribeEvent(Pair pair, Action action) {
        this.f12251a = pair;
        this.f12252b = action;
    }

    public final /* synthetic */ Object m20278c() {
        return this.f12251a;
    }
}
