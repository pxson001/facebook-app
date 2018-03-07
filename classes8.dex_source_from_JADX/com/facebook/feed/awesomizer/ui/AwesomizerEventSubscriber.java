package com.facebook.feed.awesomizer.ui;

import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feed.util.event.AwesomizerViewEvents.CardClosedEvent;
import com.facebook.inject.Assisted;
import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: has_impression_cap_reached */
public class AwesomizerEventSubscriber {
    public final Function<CardClosedEvent, Void> f11729a;
    public final EventsStream f11730b;
    public final List<Subscription> f11731c = new ArrayList();

    /* compiled from: has_impression_cap_reached */
    public class C12571 implements Action<CardClosedEvent> {
        final /* synthetic */ AwesomizerEventSubscriber f11728a;

        public C12571(AwesomizerEventSubscriber awesomizerEventSubscriber) {
            this.f11728a = awesomizerEventSubscriber;
        }

        public final void m13832a(Object obj) {
            this.f11728a.f11729a.apply((CardClosedEvent) obj);
        }
    }

    @Inject
    public AwesomizerEventSubscriber(@Assisted Function<CardClosedEvent, Void> function, EventsStream eventsStream) {
        this.f11729a = function;
        this.f11730b = eventsStream;
    }

    public final void m13833b() {
        for (Subscription a : this.f11731c) {
            this.f11730b.a(a);
        }
        this.f11731c.clear();
    }
}
