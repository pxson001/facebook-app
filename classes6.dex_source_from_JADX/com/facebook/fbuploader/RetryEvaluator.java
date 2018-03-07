package com.facebook.fbuploader;

import com.facebook.fbuploader.Config.RetryPolicy;

/* compiled from: newMessage */
public class RetryEvaluator {
    public final RetryPolicy f10062a;
    public int f10063b;
    public int f10064c;

    public RetryEvaluator(RetryPolicy retryPolicy) {
        this.f10062a = retryPolicy;
        m15761c();
    }

    public final void m15761c() {
        this.f10063b = 0;
        this.f10064c = this.f10062a.f10041b;
    }
}
