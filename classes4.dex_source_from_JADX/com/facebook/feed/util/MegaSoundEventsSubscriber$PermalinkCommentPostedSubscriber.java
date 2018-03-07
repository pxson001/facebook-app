package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.ufiservices.event.UfiEvents$CommentPostEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$PermalinkCommentPostedSubscriber extends UfiEvents$CommentPostEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10660a;

    public MegaSoundEventsSubscriber$PermalinkCommentPostedSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10660a = megaSoundEventsSubscriber;
    }

    public final void m11139b(FbEvent fbEvent) {
        MegaSoundEventsSubscriber.b(this.f10660a, "post_comment");
    }
}
