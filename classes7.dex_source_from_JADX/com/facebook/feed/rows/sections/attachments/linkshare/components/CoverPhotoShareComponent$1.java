package com.facebook.feed.rows.sections.attachments.linkshare.components;

import com.facebook.components.EventHandler;

/* compiled from: Verb */
class CoverPhotoShareComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f21041a;
    final /* synthetic */ Object f21042b;
    final /* synthetic */ CoverPhotoShareComponent f21043c;

    CoverPhotoShareComponent$1(CoverPhotoShareComponent coverPhotoShareComponent, EventHandler eventHandler, Object obj) {
        this.f21043c = coverPhotoShareComponent;
        this.f21041a = eventHandler;
        this.f21042b = obj;
    }

    public void run() {
        this.f21043c.a(this.f21041a, this.f21042b);
    }
}
