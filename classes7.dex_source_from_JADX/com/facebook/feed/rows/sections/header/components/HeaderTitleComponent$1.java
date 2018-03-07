package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unexpected null results from Graphql */
class HeaderTitleComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21342a;
    final /* synthetic */ Object f21343b;
    final /* synthetic */ HeaderTitleComponent f21344c;

    HeaderTitleComponent$1(HeaderTitleComponent headerTitleComponent, EventHandler eventHandler, Object obj) {
        this.f21344c = headerTitleComponent;
        this.f21342a = eventHandler;
        this.f21343b = obj;
    }

    public void run() {
        this.f21344c.a(this.f21342a, this.f21343b);
    }
}
