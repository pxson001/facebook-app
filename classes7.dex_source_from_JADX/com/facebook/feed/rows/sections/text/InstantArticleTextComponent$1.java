package com.facebook.feed.rows.sections.text;

import com.facebook.components.EventHandler;

/* compiled from: UNDO_CLICKED */
class InstantArticleTextComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21576a;
    final /* synthetic */ Object f21577b;
    final /* synthetic */ InstantArticleTextComponent f21578c;

    InstantArticleTextComponent$1(InstantArticleTextComponent instantArticleTextComponent, EventHandler eventHandler, Object obj) {
        this.f21578c = instantArticleTextComponent;
        this.f21576a = eventHandler;
        this.f21577b = obj;
    }

    public void run() {
        this.f21578c.a(this.f21576a, this.f21577b);
    }
}
