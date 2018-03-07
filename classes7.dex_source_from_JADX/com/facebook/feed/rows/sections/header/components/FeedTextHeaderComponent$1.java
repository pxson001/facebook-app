package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unknown query param name  */
class FeedTextHeaderComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21227a;
    final /* synthetic */ Object f21228b;
    final /* synthetic */ FeedTextHeaderComponent f21229c;

    FeedTextHeaderComponent$1(FeedTextHeaderComponent feedTextHeaderComponent, EventHandler eventHandler, Object obj) {
        this.f21229c = feedTextHeaderComponent;
        this.f21227a = eventHandler;
        this.f21228b = obj;
    }

    public void run() {
        this.f21229c.a(this.f21227a, this.f21228b);
    }
}
