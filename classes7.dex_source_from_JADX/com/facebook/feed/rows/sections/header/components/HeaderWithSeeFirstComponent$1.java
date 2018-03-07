package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unexpected moov box. */
class HeaderWithSeeFirstComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21345a;
    final /* synthetic */ Object f21346b;
    final /* synthetic */ HeaderWithSeeFirstComponent f21347c;

    HeaderWithSeeFirstComponent$1(HeaderWithSeeFirstComponent headerWithSeeFirstComponent, EventHandler eventHandler, Object obj) {
        this.f21347c = headerWithSeeFirstComponent;
        this.f21345a = eventHandler;
        this.f21346b = obj;
    }

    public void run() {
        this.f21347c.a(this.f21345a, this.f21346b);
    }
}
