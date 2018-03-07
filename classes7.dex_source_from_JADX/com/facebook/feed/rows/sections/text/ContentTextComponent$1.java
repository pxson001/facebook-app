package com.facebook.feed.rows.sections.text;

import com.facebook.components.EventHandler;

/* compiled from: UNREGISTER */
class ContentTextComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21562a;
    final /* synthetic */ Object f21563b;
    final /* synthetic */ ContentTextComponent f21564c;

    ContentTextComponent$1(ContentTextComponent contentTextComponent, EventHandler eventHandler, Object obj) {
        this.f21564c = contentTextComponent;
        this.f21562a = eventHandler;
        this.f21563b = obj;
    }

    public void run() {
        this.f21564c.a(this.f21562a, this.f21563b);
    }
}
