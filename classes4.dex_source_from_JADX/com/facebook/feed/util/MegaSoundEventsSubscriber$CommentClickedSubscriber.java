package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.UfiEvents.CommentButtonClickedEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$CommentClickedSubscriber extends CommentButtonClickedEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10657a;

    public MegaSoundEventsSubscriber$CommentClickedSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10657a = megaSoundEventsSubscriber;
    }

    public final void m11134b(FbEvent fbEvent) {
        MegaSoundEventsSubscriber.b(this.f10657a, "comment");
    }
}
