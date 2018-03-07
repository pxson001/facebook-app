package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unknown condition type  */
class FollowableHeaderComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21255a;
    final /* synthetic */ Object f21256b;
    final /* synthetic */ FollowableHeaderComponent f21257c;

    FollowableHeaderComponent$1(FollowableHeaderComponent followableHeaderComponent, EventHandler eventHandler, Object obj) {
        this.f21257c = followableHeaderComponent;
        this.f21255a = eventHandler;
        this.f21256b = obj;
    }

    public void run() {
        this.f21257c.a(this.f21255a, this.f21256b);
    }
}
