package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unexpected height! expected= */
class LikableHeaderComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21356a;
    final /* synthetic */ Object f21357b;
    final /* synthetic */ LikableHeaderComponent f21358c;

    LikableHeaderComponent$1(LikableHeaderComponent likableHeaderComponent, EventHandler eventHandler, Object obj) {
        this.f21358c = likableHeaderComponent;
        this.f21356a = eventHandler;
        this.f21357b = obj;
    }

    public void run() {
        this.f21358c.a(this.f21356a, this.f21357b);
    }
}
