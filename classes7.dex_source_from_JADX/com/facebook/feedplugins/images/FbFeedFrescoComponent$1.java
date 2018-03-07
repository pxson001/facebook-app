package com.facebook.feedplugins.images;

import com.facebook.components.EventHandler;

/* compiled from: SWIPE */
class FbFeedFrescoComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f23500a;
    final /* synthetic */ Object f23501b;
    final /* synthetic */ FbFeedFrescoComponent f23502c;

    FbFeedFrescoComponent$1(FbFeedFrescoComponent fbFeedFrescoComponent, EventHandler eventHandler, Object obj) {
        this.f23502c = fbFeedFrescoComponent;
        this.f23500a = eventHandler;
        this.f23501b = obj;
    }

    public void run() {
        this.f23502c.a(this.f23500a, this.f23501b);
    }
}
