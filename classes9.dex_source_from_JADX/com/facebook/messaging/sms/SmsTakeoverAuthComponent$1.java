package com.facebook.messaging.sms;

import com.facebook.messaging.sms.analytics.SmsCallerContext;

/* compiled from: compileShader */
class SmsTakeoverAuthComponent$1 implements Runnable {
    final /* synthetic */ SmsTakeoverAuthComponent f17487a;

    SmsTakeoverAuthComponent$1(SmsTakeoverAuthComponent smsTakeoverAuthComponent) {
        this.f17487a = smsTakeoverAuthComponent;
    }

    public void run() {
        this.f17487a.e.a(SmsCallerContext.LOGGED_OUT, this.f17487a.b, false);
    }
}
