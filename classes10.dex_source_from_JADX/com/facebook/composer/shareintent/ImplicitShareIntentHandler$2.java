package com.facebook.composer.shareintent;

import android.content.Intent;

/* compiled from: controller_initialized */
class ImplicitShareIntentHandler$2 implements Runnable {
    final /* synthetic */ Intent f15852a;
    final /* synthetic */ ImplicitShareIntentHandler f15853b;

    ImplicitShareIntentHandler$2(ImplicitShareIntentHandler implicitShareIntentHandler, Intent intent) {
        this.f15853b = implicitShareIntentHandler;
        this.f15852a = intent;
    }

    public void run() {
        if (this.f15853b.S != null) {
            this.f15853b.S.a(null, this.f15853b, this.f15852a, false, ImplicitShareIntentHandler.b(this.f15853b));
        } else {
            this.f15853b.O.a(this.f15852a, 42, this.f15853b);
        }
    }
}
