package com.facebook.feedplugins.pyml.rows.components;

import com.facebook.components.EventHandler;

/* compiled from: android.settings.INTERNAL_STORAGE_SETTINGS */
class PagesYouMayLikeComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f19797a;
    final /* synthetic */ Object f19798b;
    final /* synthetic */ PagesYouMayLikeComponent f19799c;

    PagesYouMayLikeComponent$1(PagesYouMayLikeComponent pagesYouMayLikeComponent, EventHandler eventHandler, Object obj) {
        this.f19799c = pagesYouMayLikeComponent;
        this.f19797a = eventHandler;
        this.f19798b = obj;
    }

    public void run() {
        this.f19799c.a(this.f19797a, this.f19798b);
    }
}
