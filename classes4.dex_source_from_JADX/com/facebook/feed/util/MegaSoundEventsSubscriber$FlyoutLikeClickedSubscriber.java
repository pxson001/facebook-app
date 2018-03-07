package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.FlyoutEvents$LikeClickedEvent;
import com.facebook.ufiservices.event.FlyoutEvents$LikeClickedEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$FlyoutLikeClickedSubscriber extends FlyoutEvents$LikeClickedEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10673a;

    public MegaSoundEventsSubscriber$FlyoutLikeClickedSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10673a = megaSoundEventsSubscriber;
    }

    public final void m11147b(FbEvent fbEvent) {
        if (((FlyoutEvents$LikeClickedEvent) fbEvent).f10676a.y_()) {
            MegaSoundEventsSubscriber.b(this.f10673a, "like_main");
        }
    }
}
