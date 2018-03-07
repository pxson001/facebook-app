package com.facebook.feed.rows.sections.components;

import com.facebook.components.EventHandler;

/* compiled from: Unsupported type  */
class FeedBackgroundStylerComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21121a;
    final /* synthetic */ Object f21122b;
    final /* synthetic */ FeedBackgroundStylerComponent f21123c;

    FeedBackgroundStylerComponent$1(FeedBackgroundStylerComponent feedBackgroundStylerComponent, EventHandler eventHandler, Object obj) {
        this.f21123c = feedBackgroundStylerComponent;
        this.f21121a = eventHandler;
        this.f21122b = obj;
    }

    public void run() {
        this.f21123c.a(this.f21121a, this.f21122b);
    }
}
