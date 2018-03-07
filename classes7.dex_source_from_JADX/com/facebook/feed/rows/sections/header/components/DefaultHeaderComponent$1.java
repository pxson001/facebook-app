package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unknown viewType while binding in  */
class DefaultHeaderComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21198a;
    final /* synthetic */ Object f21199b;
    final /* synthetic */ DefaultHeaderComponent f21200c;

    DefaultHeaderComponent$1(DefaultHeaderComponent defaultHeaderComponent, EventHandler eventHandler, Object obj) {
        this.f21200c = defaultHeaderComponent;
        this.f21198a = eventHandler;
        this.f21199b = obj;
    }

    public void run() {
        this.f21200c.a(this.f21198a, this.f21199b);
    }
}
