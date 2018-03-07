package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unimplemented Context Menu Entry! */
class HeaderActorComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21312a;
    final /* synthetic */ Object f21313b;
    final /* synthetic */ HeaderActorComponent f21314c;

    HeaderActorComponent$1(HeaderActorComponent headerActorComponent, EventHandler eventHandler, Object obj) {
        this.f21314c = headerActorComponent;
        this.f21312a = eventHandler;
        this.f21313b = obj;
    }

    public void run() {
        this.f21314c.a(this.f21312a, this.f21313b);
    }
}
