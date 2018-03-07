package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.FlyoutEvents$PostCommentEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$CommentPostedSubscriber extends FlyoutEvents$PostCommentEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10674a;

    public MegaSoundEventsSubscriber$CommentPostedSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10674a = megaSoundEventsSubscriber;
    }

    public final void m11149b(FbEvent fbEvent) {
        MegaSoundEventsSubscriber.b(this.f10674a, "post_comment");
    }
}
