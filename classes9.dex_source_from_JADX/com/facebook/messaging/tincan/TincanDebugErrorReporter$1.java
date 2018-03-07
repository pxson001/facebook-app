package com.facebook.messaging.tincan;

import android.widget.Toast;

/* compiled from: com.facebook.FacebookException */
class TincanDebugErrorReporter$1 implements Runnable {
    final /* synthetic */ String f17853a;
    final /* synthetic */ TincanDebugErrorReporter f17854b;

    TincanDebugErrorReporter$1(TincanDebugErrorReporter tincanDebugErrorReporter, String str) {
        this.f17854b = tincanDebugErrorReporter;
        this.f17853a = str;
    }

    public void run() {
        Toast.makeText(this.f17854b.b, this.f17853a, 1).show();
    }
}
