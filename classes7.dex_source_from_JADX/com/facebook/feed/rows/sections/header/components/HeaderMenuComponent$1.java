package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unhandled msg what= */
class HeaderMenuComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21326a;
    final /* synthetic */ Object f21327b;
    final /* synthetic */ HeaderMenuComponent f21328c;

    HeaderMenuComponent$1(HeaderMenuComponent headerMenuComponent, EventHandler eventHandler, Object obj) {
        this.f21328c = headerMenuComponent;
        this.f21326a = eventHandler;
        this.f21327b = obj;
    }

    public void run() {
        this.f21328c.a(this.f21326a, this.f21327b);
    }
}
