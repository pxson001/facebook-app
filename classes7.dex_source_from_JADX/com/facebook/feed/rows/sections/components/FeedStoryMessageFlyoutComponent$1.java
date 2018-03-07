package com.facebook.feed.rows.sections.components;

import com.facebook.components.EventHandler;

/* compiled from: Unsupported type */
class FeedStoryMessageFlyoutComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21124a;
    final /* synthetic */ Object f21125b;
    final /* synthetic */ FeedStoryMessageFlyoutComponent f21126c;

    FeedStoryMessageFlyoutComponent$1(FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, EventHandler eventHandler, Object obj) {
        this.f21126c = feedStoryMessageFlyoutComponent;
        this.f21124a = eventHandler;
        this.f21125b = obj;
    }

    public void run() {
        this.f21126c.a(this.f21124a, this.f21125b);
    }
}
