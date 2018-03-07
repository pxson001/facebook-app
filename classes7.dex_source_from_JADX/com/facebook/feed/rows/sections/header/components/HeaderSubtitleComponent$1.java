package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unexpected start indicator reading extended header */
class HeaderSubtitleComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21336a;
    final /* synthetic */ Object f21337b;
    final /* synthetic */ HeaderSubtitleComponent f21338c;

    HeaderSubtitleComponent$1(HeaderSubtitleComponent headerSubtitleComponent, EventHandler eventHandler, Object obj) {
        this.f21338c = headerSubtitleComponent;
        this.f21336a = eventHandler;
        this.f21337b = obj;
    }

    public void run() {
        this.f21338c.a(this.f21336a, this.f21337b);
    }
}
