package com.facebook.messaging.media.upload;

import com.facebook.messaging.media.upload.TwoPhaseSendHandler.1;

/* compiled from: launch_mode_extra */
class TwoPhaseSendHandler$1$1 implements Runnable {
    final /* synthetic */ String f12061a;
    final /* synthetic */ String f12062b;
    final /* synthetic */ 1 f12063c;

    TwoPhaseSendHandler$1$1(1 1, String str, String str2) {
        this.f12063c = 1;
        this.f12061a = str;
        this.f12062b = str2;
    }

    public void run() {
        TwoPhaseSendHandler.a(this.f12063c.a, this.f12061a, this.f12062b);
    }
}
