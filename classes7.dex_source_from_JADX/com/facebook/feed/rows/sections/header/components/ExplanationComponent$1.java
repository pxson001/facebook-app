package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unknown type */
class ExplanationComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21201a;
    final /* synthetic */ Object f21202b;
    final /* synthetic */ ExplanationComponent f21203c;

    ExplanationComponent$1(ExplanationComponent explanationComponent, EventHandler eventHandler, Object obj) {
        this.f21203c = explanationComponent;
        this.f21201a = eventHandler;
        this.f21202b = obj;
    }

    public void run() {
        this.f21203c.a(this.f21201a, this.f21202b);
    }
}
