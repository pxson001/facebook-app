package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.UfiEvents$CommentLikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents$CommentLikeClickedEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$PermalinkCommentLikeClickedSubscriber extends UfiEvents$CommentLikeClickedEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10659a;

    public MegaSoundEventsSubscriber$PermalinkCommentLikeClickedSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10659a = megaSoundEventsSubscriber;
    }

    public final void m11137b(FbEvent fbEvent) {
        if (!((UfiEvents$CommentLikeClickedEvent) fbEvent).f10668a.k()) {
            MegaSoundEventsSubscriber.b(this.f10659a, "like_comment");
        }
    }
}
