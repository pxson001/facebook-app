package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unexpected operation type  */
class HeaderTitleAndSubtitleComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21339a;
    final /* synthetic */ Object f21340b;
    final /* synthetic */ HeaderTitleAndSubtitleComponent f21341c;

    HeaderTitleAndSubtitleComponent$1(HeaderTitleAndSubtitleComponent headerTitleAndSubtitleComponent, EventHandler eventHandler, Object obj) {
        this.f21341c = headerTitleAndSubtitleComponent;
        this.f21339a = eventHandler;
        this.f21340b = obj;
    }

    public void run() {
        this.f21341c.a(this.f21339a, this.f21340b);
    }
}
