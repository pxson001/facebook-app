package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unicode Exception */
class HeaderLikeButtonComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21315a;
    final /* synthetic */ Object f21316b;
    final /* synthetic */ HeaderLikeButtonComponent f21317c;

    HeaderLikeButtonComponent$1(HeaderLikeButtonComponent headerLikeButtonComponent, EventHandler eventHandler, Object obj) {
        this.f21317c = headerLikeButtonComponent;
        this.f21315a = eventHandler;
        this.f21316b = obj;
    }

    public void run() {
        this.f21317c.a(this.f21315a, this.f21316b);
    }
}
