package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.FlyoutEvents$CommentLikeClickedEvent;
import com.facebook.ufiservices.event.FlyoutEvents$CommentLikeClickedEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$CommentLikeClickedSubscriber extends FlyoutEvents$CommentLikeClickedEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10672a;

    public MegaSoundEventsSubscriber$CommentLikeClickedSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10672a = megaSoundEventsSubscriber;
    }

    public final void m11145b(FbEvent fbEvent) {
        if (!((FlyoutEvents$CommentLikeClickedEvent) fbEvent).f10675a.k()) {
            MegaSoundEventsSubscriber.b(this.f10672a, "like_comment");
        }
    }
}
