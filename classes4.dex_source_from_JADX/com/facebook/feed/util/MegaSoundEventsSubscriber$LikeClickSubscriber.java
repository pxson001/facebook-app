package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.UfiEvents$LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents$LikeClickedEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$LikeClickSubscriber extends UfiEvents$LikeClickedEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10656a;

    public MegaSoundEventsSubscriber$LikeClickSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10656a = megaSoundEventsSubscriber;
    }

    public final void m11132b(FbEvent fbEvent) {
        if (((UfiEvents$LikeClickedEvent) fbEvent).f10664d) {
            MegaSoundEventsSubscriber.b(this.f10656a, "like_main");
        }
    }
}
