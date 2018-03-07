package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.EventHandler;

/* compiled from: Unknown module type  */
class FollowButtonComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21238a;
    final /* synthetic */ Object f21239b;
    final /* synthetic */ FollowButtonComponent f21240c;

    FollowButtonComponent$1(FollowButtonComponent followButtonComponent, EventHandler eventHandler, Object obj) {
        this.f21240c = followButtonComponent;
        this.f21238a = eventHandler;
        this.f21239b = obj;
    }

    public void run() {
        this.f21240c.a(this.f21238a, this.f21239b);
    }
}
