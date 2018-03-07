package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.UfiEvents$ShareClickedEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$ShareClickedSubscriber extends UfiEvents$ShareClickedEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10658a;

    public MegaSoundEventsSubscriber$ShareClickedSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10658a = megaSoundEventsSubscriber;
    }

    public final void m11135b(FbEvent fbEvent) {
        MegaSoundEventsSubscriber.b(this.f10658a, "share");
    }
}
