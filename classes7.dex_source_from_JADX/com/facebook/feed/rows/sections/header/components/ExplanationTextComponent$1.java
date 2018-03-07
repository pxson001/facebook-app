package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unknown query param type  */
class ExplanationTextComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21213a;
    final /* synthetic */ Object f21214b;
    final /* synthetic */ ExplanationTextComponent f21215c;

    ExplanationTextComponent$1(ExplanationTextComponent explanationTextComponent, EventHandler eventHandler, Object obj) {
        this.f21215c = explanationTextComponent;
        this.f21213a = eventHandler;
        this.f21214b = obj;
    }

    public void run() {
        this.f21215c.a(this.f21213a, this.f21214b);
    }
}
