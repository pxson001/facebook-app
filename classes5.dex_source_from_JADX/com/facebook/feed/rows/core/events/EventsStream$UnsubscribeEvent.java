package com.facebook.feed.rows.core.events;

/* compiled from: WeakPassword */
class EventsStream$UnsubscribeEvent implements KeyedEvent<Subscription> {
    private final Subscription f12253a;

    public EventsStream$UnsubscribeEvent(Subscription subscription) {
        this.f12253a = subscription;
    }

    public final Object m20279c() {
        return this.f12253a;
    }
}
