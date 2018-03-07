package com.facebook.events.permalink.actionbar;

import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import java.util.Iterator;

/* compiled from: caller_is_syncadapter */
public class EventActionBarButtonsBuilder implements Iterable<EventsActionBarButtonType> {
    private final Builder<EventsActionBarButtonType> f18053a = new Builder();
    private final Builder<EventsActionBarButtonType> f18054b = new Builder();
    private final int f18055c;
    private int f18056d;

    public EventActionBarButtonsBuilder(int i) {
        this.f18055c = i;
    }

    public final void m18418a(EventsActionBarButtonType eventsActionBarButtonType) {
        this.f18053a.c(eventsActionBarButtonType);
        this.f18056d++;
    }

    public final void m18420b(EventsActionBarButtonType eventsActionBarButtonType) {
        this.f18054b.c(eventsActionBarButtonType);
    }

    public final void m18419a(EventsActionBarButtonType eventsActionBarButtonType, EventsActionBarButtonType eventsActionBarButtonType2) {
        if (this.f18056d + 1 < this.f18055c) {
            m18418a(eventsActionBarButtonType);
        } else {
            m18420b(eventsActionBarButtonType2);
        }
    }

    public Iterator<EventsActionBarButtonType> iterator() {
        return Iterables.b(this.f18053a.b(), this.f18054b.b()).iterator();
    }

    public final int m18417a() {
        return Math.min(this.f18056d + 1, this.f18055c);
    }
}
